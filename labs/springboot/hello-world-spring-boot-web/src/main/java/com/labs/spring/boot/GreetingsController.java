package com.labs.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	Logger logger = LoggerFactory.getLogger(GreetingsController.class);
	
	
	@GetMapping("/greetings")
	public String greetings() {
		
		logger.trace("TRACE LOG");
		logger.trace("DEBUG LOG");
		logger.trace("INFO LOG");
		logger.trace("WARN LOG");
		logger.trace("ERROR LOG");
		
		
		return "Welcome to Spring Boot Web demo";
	}
}