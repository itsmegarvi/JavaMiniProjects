package com.mis.phonebookwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mis.entity")
@ComponentScan(basePackages = "com.mis.*")
@EnableJpaRepositories(basePackages = "com.mis.repository")
public class PhoneBookWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(PhoneBookWebAppApplication.class, args);
	}

}
