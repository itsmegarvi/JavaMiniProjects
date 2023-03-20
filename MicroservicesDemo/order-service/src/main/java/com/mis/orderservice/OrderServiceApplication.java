package com.mis.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.mis.*")
@EnableDiscoveryClient
public class OrderServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrderServiceApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
