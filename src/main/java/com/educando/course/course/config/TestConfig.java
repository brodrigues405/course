package com.educando.course.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educando.course.course.model.Category;
import com.educando.course.course.model.Order;
import com.educando.course.course.model.OrderItem;
import com.educando.course.course.model.Payment;
import com.educando.course.course.model.Product;
import com.educando.course.course.model.User;
import com.educando.course.course.model.enums.OrderStatus;
import com.educando.course.course.repositories.CategoryRepository;
import com.educando.course.course.repositories.OderItemRepository;
import com.educando.course.course.repositories.OrderRepository;
import com.educando.course.course.repositories.ProductRepository;
import com.educando.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productReposotory;
	
	@Autowired
	private OderItemRepository orderItemRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null,"Computers");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		productReposotory.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productReposotory.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		User user1 = new User(null, "Ludiana Soarea", "ludiana@gmail","98775466","115568");
		User user2 = new User(null, "Adrian Soares B. Rodrigues", "ludiana@gmail","98775466","115568");
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.now(), user2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.now(), user1, OrderStatus.SHIPPED);
		
		
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		
		Payment pay1 = new Payment(null, Instant.now(), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);

		
		
	}
	
	

	

}
