package com.mis.springrestjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mis.jpa.model")
@ComponentScan(basePackages = "com.mis.jpa.*")
@EnableJpaRepositories("com.mis.jpa.repository")
public class SpringRestJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestJpaDemoApplication.class, args);
    }

}
