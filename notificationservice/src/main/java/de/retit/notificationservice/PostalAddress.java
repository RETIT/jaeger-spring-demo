package de.retit.notificationservice;

public class PostalAddress {
    private String firstname;
    private String surname;
    private String street;
    private String streetno;
    private String zip;
    private String city;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public PostalAddress initializeFromAddress(Address a) {
        this.street = a.getStreet();
        this.streetno = a.getStreetno();
        this.zip = a.getZip();
        this.city = a.getCity();
        return this;
    }

    @Override
    public String toString() {
        return "PostalAddress{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", street='" + street + '\'' +
                ", streetno='" + streetno + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
