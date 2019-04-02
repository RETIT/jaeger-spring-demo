package de.retit.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping("/purchase/{purchaseid}")
    public Purchase getPurchase(@PathVariable Long purchaseid) throws PurchaseNotFoundException {
        Optional<Purchase> purchase = purchaseRepository.findById(purchaseid);
        if(purchase.isPresent()) {
            return purchase.get();
        }
        else {
            throw new PurchaseNotFoundException();
        }
    }

    @GetMapping("/purchases/product/{productid}")
    public List<Purchase> getProductPurchases(@PathVariable Long productid) {
        return purchaseRepository.findAllProductPurchases(productid);
    }

    @GetMapping("/purchases/customer/{customerid}")
    public List<Purchase> getCustomerPurchases(@PathVariable Long customerid) {
        return purchaseRepository.findAllCustomerPurchases(customerid);
    }
}
