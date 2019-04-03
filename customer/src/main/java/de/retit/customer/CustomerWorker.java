package de.retit.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Simulate any customer related work.
 */
public class CustomerWorker {

    private static final Random random = new Random();

    @Autowired
    CustomerRepository customerRepository;

    public Customer loadSingleCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        else {
            throw new CustomerNotFoundException();
        }
    }

    public List<Customer> loadCustomers(@PathVariable List<Long> ids) {
        List<Customer> customers = customerRepository.findAllById(ids);
        // delay between 300 and 350ms
        try {
            Thread.sleep(random.nextInt(50) + 300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
