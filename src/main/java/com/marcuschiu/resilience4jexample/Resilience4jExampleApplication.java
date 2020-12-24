package com.marcuschiu.resilience4jexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class Resilience4jExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jExampleApplication.class, args);
	}

}
