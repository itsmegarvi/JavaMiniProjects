package com.eurekaservermaking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMakingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMakingApplication.class, args);
	}

}
