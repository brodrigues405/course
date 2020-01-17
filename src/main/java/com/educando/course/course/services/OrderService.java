package com.educando.course.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.course.model.Order;
import com.educando.course.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> buscaOrders(){
		return orderRepository.findAll();
	}
	
	public Order buscaOrderPorID(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
	
	
}
