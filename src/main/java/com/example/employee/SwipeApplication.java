package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SwipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwipeApplication.class, args);
	}

}
