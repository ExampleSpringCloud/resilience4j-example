package com.marcuschiu.resilience4jexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExampleManualService {

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    RestTemplate restTemplate;

    public ExampleManualService() {
        restTemplate = new RestTemplate();
    }

    public String getAlbumList() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        return circuitBreaker.run(this::defaultGet, throwable -> fallBackGet());
    }

    private String defaultGet() {
        System.out.println("Default Get");
        String url = "http://localhost:1234/not-real";
        return restTemplate.getForObject(url, String.class);
    }

    private String fallBackGet() {
        System.out.println("Fallback Get");
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "https://jsonplaceholder.typicode.com/albums";
        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class));
    }
}
