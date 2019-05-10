package com.brown.consumingrestlab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConsumingRestLabApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestLabApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ConsumingRestLabApplication.class, args);
	}
@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
}

@Bean
		public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	return args -> {
		UserInfo userInfo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", UserInfo.class);
		log.info(userInfo.toString());
	};
}

	}
