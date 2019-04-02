package de.retit.notificationdispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationDispatcherApplication {

	@Bean
	DemoDispatcherWorker createWorker() {
		return  new DemoDispatcherWorker();
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationDispatcherApplication.class, args);
	}

}
