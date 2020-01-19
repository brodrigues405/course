package com.educando.course.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.course.model.Product;
import com.educando.course.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> buscarProducts() {
		return productRepository.findAll();
	}

	public Product buscarProductPorID(Long id) {

		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}

}
