package com.mis.jparestdemo2;

import com.mis.entity.Student;
import com.mis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = "com.mis.entity")
@ComponentScan(basePackages={"com.mis.*"})
@EnableJpaRepositories(basePackages = "com.mis.repository")
public class JpaRestDemo2Application implements CommandLineRunner{
	@Autowired
	StudentRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(JpaRestDemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Student> str = repo.findById(1200L);
		Student st = str.get();
		System.out.println(st);
		System.out.println(str);
	}

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
