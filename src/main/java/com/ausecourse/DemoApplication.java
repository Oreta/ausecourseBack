package com.ausecourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import service.EmailService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		new EmailService().sendMail("mr.gean", "dilido@hotmail.fr", "imp", "text");
		//SpringApplication.run(DemoApplication.class, args);
	}
}
