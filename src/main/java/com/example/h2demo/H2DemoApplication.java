package com.example.h2demo;

import com.example.h2demo.entity.User;
import com.example.h2demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return runner -> {
			createUsers(userService);
		};
	}

	private void createUsers(UserService userService) {
		User user1 = new User("Raman", "Raghav", "raman.raghav@abc.com");
		User user2 = new User("Aman", "Singh", "aman.kashyap@pqr.com");
		User user3 = new User("Karan", "Kashyap", "karan.kashyap@xyz.com");

		userService.save(user1);
		userService.save(user2);
		userService.save(user3);

		System.out.println("Saved students " );
	}
}
