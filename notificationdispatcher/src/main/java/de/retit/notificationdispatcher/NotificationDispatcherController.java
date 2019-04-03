package de.retit.notificationdispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class NotificationDispatcherController {

    @Autowired
    DemoDispatcherWorker dispatcherWorker;

    @PostMapping("/dispatch")
    public void dispatch(@RequestBody Notification notification) {
        notification.getPostalAddresses().forEach(a -> dispatcherWorker.sendLetter(notification.getMessage(), a));
    }
}
