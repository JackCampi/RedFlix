package com.redflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tablas.Director;

@SpringBootApplication
@ComponentScan("com.redflix")
@EntityScan("com.tablas")
@EnableJpaRepositories("com.repos")
public class BasicApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BasicApplication.class, args);
		
	}
}
