package com.labs.spring.boot;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;

@SpringBootApplication
public class HelloWorldSpringBootApplication implements CommandLineRunner {
	@Autowired
	ApplicationContext context;

	Logger logger = LoggerFactory.getLogger(HelloWorldSpringBootApplication.class);

	public static void main(String[] args) {
		System.out.println("before launch");
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
		System.out.println("before launch");
	}

	public void showGreetingsMsg(){
		Greetings greetings = new Greetings();
		greetings.getMessage();
		System.out.println(greetings.getMessage());

	}

	@Bean
	public Greetings greetings(){
		return new Greetings();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("context: "+ context);
		System.out.println("No. of Beans: " + context.getBeanDefinitionCount());
	}
}
