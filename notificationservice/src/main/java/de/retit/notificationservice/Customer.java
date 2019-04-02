package de.retit.notificationservice;

import java.util.List;

public class Customer {

    private String surname;
    private String firstname;
    private List<Address> addresses;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public Customer(String surname, String firstname) {
        this.surname = surname;
        this.firstname = firstname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public PostalAddress generatePostalAddress() {
        PostalAddress result = new PostalAddress();
        result.setFirstname(this.firstname);
        result.setSurname(this.surname);
        result.initializeFromAddress(addresses.stream().filter(Address::isIspostaladdress).findFirst().orElse(null));
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
