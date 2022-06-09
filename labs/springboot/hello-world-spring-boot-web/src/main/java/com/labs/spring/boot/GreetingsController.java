package com.labs.spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@GetMapping("/greetings")
	public String greetings() {
		return "Welcome to Spring Boot Web demo";
	}
}