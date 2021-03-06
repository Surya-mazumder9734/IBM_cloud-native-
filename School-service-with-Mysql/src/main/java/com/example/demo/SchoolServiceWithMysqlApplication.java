package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class SchoolServiceWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceWithMysqlApplication.class, args);
	}

}
