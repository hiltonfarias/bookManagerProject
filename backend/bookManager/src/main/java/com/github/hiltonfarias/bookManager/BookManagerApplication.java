package com.github.hiltonfarias.bookManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BookManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class, args);
	}

}
