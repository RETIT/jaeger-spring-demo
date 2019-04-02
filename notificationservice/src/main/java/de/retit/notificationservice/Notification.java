package de.retit.notificationservice;

import java.util.List;

public class Notification {

    private String message;
    private List<PostalAddress> postalAddresses;

    public Notification(String message, List<PostalAddress> postalAddresses) {
        this.message = message;
        this.postalAddresses = postalAddresses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PostalAddress> getPostalAddresses() {
        return postalAddresses;
    }

    public void setPostalAddresses(List<PostalAddress> postalAddresses) {
        this.postalAddresses = postalAddresses;
    }
}
