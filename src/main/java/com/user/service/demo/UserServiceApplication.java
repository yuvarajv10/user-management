package com.user.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Users Application Startup.
 * 
 * @author yuvaraj
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class UserServiceApplication {

	/*
	 * Main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
