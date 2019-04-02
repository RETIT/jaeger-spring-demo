package de.retit.purchase;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerid;
    private Long productid;
    private Instant purchasedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Instant getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Instant purchasedate) {
        this.purchasedate = purchasedate;
    }
}
