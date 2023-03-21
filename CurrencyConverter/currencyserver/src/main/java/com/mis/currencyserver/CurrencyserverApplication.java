package com.mis.currencyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CurrencyserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyserverApplication.class, args);
	}

}
