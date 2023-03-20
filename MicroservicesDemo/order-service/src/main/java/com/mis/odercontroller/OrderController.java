package com.mis.odercontroller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String ORDER_SERVICE="orderService";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/orders")
    @CircuitBreaker(name="ORDER_SERVICE" ,fallbackMethod="orderFallback")
    public ResponseEntity<String> getOrder()
    {
        String response=restTemplate.getForObject("http://localhost:6975/items/getall",String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    public ResponseEntity<String> orderFallback(Exception e)
    {
        return new ResponseEntity<String>("Item Service is down..pls try later",HttpStatus.OK);
    }
}
