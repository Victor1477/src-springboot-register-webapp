package com.contacts.webproject.webapp;

import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		System.setOut(new PrintStream(new ConsoleOutputStream()));
		SpringApplication.run(WebappApplication.class, args);
	}
}