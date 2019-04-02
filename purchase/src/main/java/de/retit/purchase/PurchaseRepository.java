package de.retit.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT p FROM Purchase p WHERE p.productid = ?1")
    List<Purchase> findAllProductPurchases(Long productid);

    @Query("SELECT p FROM Purchase p WHERE p.customerid = ?1")
    List<Purchase> findAllCustomerPurchases(Long customerid);
}
