package com.mis.busbookingapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mis.entity")
@ComponentScan(basePackages = "com.mis.*")
@EnableJpaRepositories(basePackages = "com.mis.repository")
public class BusBookingAppsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusBookingAppsApplication.class, args);
    }

}
