package de.retit.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class CustomerController {

    private static final Random random = new Random();

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        else {
            throw new CustomerNotFoundException();
        }
    }

    @GetMapping("customers/{ids}")
    public List<Customer> getCustomers(@PathVariable List<Long> ids) {
        List<Customer> customers = customerRepository.findAllById(ids);
        // delay between 150 and 250ms
        try {
            Thread.sleep(random.nextInt(100) + 150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
