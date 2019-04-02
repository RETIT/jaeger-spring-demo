package de.retit.notificationservice;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class NotificationController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @Value("${customer.service.url}")
    private String customerUrl;

    @Value("${purchase.service.url}")
    private String purchaseUrl;

    @Value("${notificationdispatcher.service.url}")
    private String notificationdispatcherUrl;

    /**
     * Dispatch notifications to all customers who purchased the respective product.
     * @param productId
     * @param message
     * @return
     */
    @PostMapping(value = "/notify/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NotificationStatus>> notifyProductCustomers(@PathVariable Long productId,
                                                                           @RequestBody(required = false) String message) {
        ResponseEntity<List<Purchase>> response = getProductPurchases(productId);
        response.getBody().forEach(System.out::println);

        List<PostalAddress> notificationAddresses = getNotificationAddresses(response.getBody());
        notificationAddresses.forEach(System.out::println);

        ResponseEntity<Void> result = dispatchNotifications(message, notificationAddresses);

        if(HttpStatus.OK.equals(result.getStatusCode())) {
            return ResponseEntity.ok(notificationAddresses.stream().map(a -> new NotificationStatus(message, a)).collect(Collectors.toList()));
        }
        else {
            throw new NotificationDispatchException();
        }
    }

    /**
     * Dispatch letters to customers.
     * @param message
     * @param notificationAddresses
     * @return
     */
    private ResponseEntity<Void> dispatchNotifications(@RequestBody(required = false) String message, List<PostalAddress> notificationAddresses) {
        Notification notification =  new Notification(message, notificationAddresses);
        return restTemplate.exchange(notificationdispatcherUrl + "/dispatch", HttpMethod.POST, new HttpEntity<>(notification), Void.class);
    }

    /**
     * Retrieve all purchases for a given product.
     * @param productId
     * @return
     */
    private ResponseEntity<List<Purchase>> getProductPurchases(Long productId) {
        return restTemplate.exchange(
                purchaseUrl + "purchases/product/" + productId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Purchase>>() {}
            );
    }

    /**
     * Retrieve the customers for the given IDs.
     * @param customerIds
     * @return
     */
    private ResponseEntity<List<Customer>> getCustomers(Set<Long> customerIds) {
        return restTemplate.exchange(
                customerUrl + "/customers/" + customerIds.stream().map(Objects::toString).collect(Collectors.joining(",")),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {}
        );
    }

    /**
     * Request all postal addresses of customers of the purchases.
     * @param body
     */
    private List<PostalAddress> getNotificationAddresses(List<Purchase> body) {
        Set<Long> customerIds = new HashSet<>();
        body.stream().forEach(p -> customerIds.add(p.getCustomerid()));
        ResponseEntity<List<Customer>> customers = getCustomers(customerIds);

        ArrayList<PostalAddress> postalAddresses = new ArrayList<>();
        customers.getBody().forEach(c -> postalAddresses.add(c.generatePostalAddress()));
        return postalAddresses;
    }
}
