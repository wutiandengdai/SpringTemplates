package com.microservice.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.microservice.webclient")
@SpringBootApplication
@EnableDiscoveryClient
public class AccountMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountMicroserviceApplication.class, args);
	}

}
