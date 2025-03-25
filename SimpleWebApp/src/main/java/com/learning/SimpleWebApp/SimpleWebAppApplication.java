package com.learning.SimpleWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleWebAppApplication {
	public static void main(String[] args) {
		try {
			SpringApplication.run(SimpleWebAppApplication.class, args);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
