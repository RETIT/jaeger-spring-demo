package de.retit.notificationservice;

import java.time.Instant;

public class Purchase {

    private Long customerid;
    private Long productid;
    private Instant purchasedate;

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

    @Override
    public String toString() {
        return "Purchase{" +
                "customerid=" + customerid +
                ", productid=" + productid +
                ", purchasedate=" + purchasedate +
                '}';
    }
}
