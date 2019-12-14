package com.cognizant.technologyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TechnologyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologyServiceApplication.class, args);
	}

}
