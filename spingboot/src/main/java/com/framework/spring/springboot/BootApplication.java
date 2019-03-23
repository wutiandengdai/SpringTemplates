package com.framework.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * application starter
 * 1.Sets up default configuration;
 * 2.Starts Spring application Context;
 * 3.Performs class path scan;
 * 4.Start Tomcat server.
 */
@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);

	}

}
