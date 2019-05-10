package com.brown.userinfo;

import com.brown.userinfo.domain.UserInfo;
import com.brown.userinfo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class UserinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinfoApplication.class, args);
	}



@Bean
CommandLineRunner run(UserService userService) {
	return args -> {
		ObjectMapper map = new ObjectMapper();
		TypeReference<List<UserInfo>> typeReference = new TypeReference<List<UserInfo>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
		try {
			List<UserInfo> users = map.readValue(inputStream, typeReference);
			userService.save(users);
			System.out.println("Users Saved!");
		} catch (IOException e) {
			System.out.println("Unable to save users: " + e.getMessage());
		}
	};
}
}

