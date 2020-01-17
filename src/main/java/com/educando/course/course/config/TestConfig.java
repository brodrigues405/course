package com.educando.course.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educando.course.course.model.Order;
import com.educando.course.course.model.User;
import com.educando.course.course.model.enums.OrderStatus;
import com.educando.course.course.repositories.OrderRepository;
import com.educando.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Ludiana Soarea", "ludiana@gmail","98775466","115568");
		User user2 = new User(null, "Adrian Soares B. Rodrigues", "ludiana@gmail","98775466","115568");
		
		
		Order o1 = new Order(null, Instant.now(), user1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.now(), user2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.now(), user1, OrderStatus.SHIPPED);
		
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
	
	

	

}
