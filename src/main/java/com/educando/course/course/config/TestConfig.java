package com.educando.course.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educando.course.course.model.User;
import com.educando.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Ludiana Soarea", "ludiana@gmail","98775466","115568");
		User user2 = new User(null, "Adrian Soares B. Rodrigues", "ludiana@gmail","98775466","115568");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
	

	

}
