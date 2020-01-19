package com.educando.course.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.course.model.Category;
import com.educando.course.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listaCategorias(){
		return categoryRepository.findAll();
	}
	
	public Category buscaCategoryPorID(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
	
	
	
	
}
