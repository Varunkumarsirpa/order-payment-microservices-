package com.example.orderservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/place")
    public String placeOrder() {

        // Call Payment Service
        String paymentResponse = restTemplate.getForObject(
                "http://localhost:8081/payment/status",
                String.class
        );

        return "Order Placed Successfully! | Payment Response: " + paymentResponse;
    }
}