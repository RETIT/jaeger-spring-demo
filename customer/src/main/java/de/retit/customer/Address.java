package de.retit.customer;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long customerid;
    private String street;
    private int streetno;
    private int zip;
    private String city;
    private boolean ispostaladdress;

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIspostaladdress() {
        return ispostaladdress;
    }

    public void setIspostaladdress(boolean ispostaladdress) {
        this.ispostaladdress = ispostaladdress;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetno() {
        return streetno;
    }

    public void setStreetno(int streetNo) {
        this.streetno = streetNo;
    }
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", customerid=" + customerid +
                ", street='" + street + '\'' +
                ", streetno=" + streetno +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                ", ispostaladdress=" + ispostaladdress +
                '}';
    }
}
