package de.retit.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	@Bean
	CustomerWorker createWorker() {
		return  new CustomerWorker();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
