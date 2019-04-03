package de.retit.notificationdispatcher;

import io.opentracing.Scope;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class DemoDispatcherWorker {

    private static final Random random = new Random();

    @Autowired
    Tracer tracer;

    /**
     * Do dummy "work" to simulate some processing between 200ms and 250ms.
     */
    public void sendLetter(String message, PostalAddress address) {
        try(Scope scope = tracer.buildSpan("sendLetter").startActive(true)) {
            scope.span().log("Sending letter to " + address);
            Thread.sleep((random.nextInt(50) + 200));
            scope.span().log("Letter was sent.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
