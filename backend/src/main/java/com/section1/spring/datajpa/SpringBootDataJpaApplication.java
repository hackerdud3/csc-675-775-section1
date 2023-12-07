package com.section1.spring.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.section1.spring.datajpa.model")
@EnableJpaRepositories(basePackages = "com.section1.spring.datajpa.repository")
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

}
