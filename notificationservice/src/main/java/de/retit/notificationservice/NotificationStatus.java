package de.retit.notificationservice;

public class NotificationStatus {

    private String message;
    private PostalAddress notifiedAddress;

    public NotificationStatus(String message, PostalAddress notifiedAddress) {
        this.message = message;
        this.notifiedAddress = notifiedAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PostalAddress getNotifiedAddress() {
        return notifiedAddress;
    }

    public void setNotifiedAddress(PostalAddress notifiedAddress) {
        this.notifiedAddress = notifiedAddress;
    }

    @Override
    public String toString() {
        return "NotificationStatus{" +
                "message='" + message + '\'' +
                ", notifiedAddress=" + notifiedAddress +
                '}';
    }
}
