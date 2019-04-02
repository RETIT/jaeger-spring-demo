package de.retit.notificationservice;

public class Address {
    private String street;
    private String streetno;
    private String zip;
    private String city;
    private boolean ispostaladdress;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetno() {
        return streetno;
    }

    public void setStreetno(String streetno) {
        this.streetno = streetno;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isIspostaladdress() {
        return ispostaladdress;
    }

    public void setIspostaladdress(boolean ispostaladdress) {
        this.ispostaladdress = ispostaladdress;
    }

    public Address(String street, String streetNo, String addition, String zip, String city) {
        this.street = street;
        this.streetno = streetNo;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", street='" + street + '\'' +
                ", streetno='" + streetno + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
