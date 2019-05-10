package com.brown.cryptonator;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CryptonatorApplication {

	private static final Logger log = LoggerFactory.getLogger(CryptonatorApplication.class);

	 public static void main(String[] args) {

		SpringApplication.run(CryptonatorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
	 	return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
	 	return args -> {
	 		Ticker ticker = restTemplate.getForObject("https://api.cryptonator.com/api/full/btc-usd", Ticker.class);
	 		log.info(ticker.toString());
		};
	}

}
