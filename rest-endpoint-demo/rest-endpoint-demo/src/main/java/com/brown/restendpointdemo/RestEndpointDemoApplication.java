package com.brown.restendpointdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestEndpointDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEndpointDemoApplication.class, args);
	}

	@RequestMapping("/greet")
	public String helloGreeting(){
		return "Hello, REST";
	}

	//this method is establishing an http endpoint to return the String defined in the method
}
