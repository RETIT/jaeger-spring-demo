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

    @Autowired
    CustomerWorker customerWorker;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        return customerWorker.loadSingleCustomer(id);
    }

    @GetMapping("customers/{ids}")
    public List<Customer> getCustomers(@PathVariable List<Long> ids) {
        return customerWorker.loadCustomers(ids);
    }
}
