package com.microservice.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.microservice.webclient.repo.AccountRepository;
import com.microservice.webclient.repo.RemoteAccountRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class WebclientMicroserviceApplication {
	public static final String ACCOUNT_URL = "http://account-microservice";
	
	public static void main(String args[]){
		SpringApplication.run(WebclientMicroserviceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public AccountRepository accountRepository(){
		return new RemoteAccountRepository(ACCOUNT_URL);
	}
	
}
