package com.mis.jpademo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mis.*")
@EntityScan(basePackages = "com.mis.entity")
@EnableJpaRepositories("com.mis.repository")
public class JpaDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemo3Application.class, args);
	}

}
