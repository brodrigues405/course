package com.educando.course.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educando.course.course.model.User;
import com.educando.course.course.repositories.UserRepository;
import com.educando.course.course.services.exceptions.DataBaseException;
import com.educando.course.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	public User buscaPorId(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	
	public void deleteUser(Long id) {
		try {
		userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	
	public User updateUser(Long id, User obj) {
		
		try {
			User objMonitorado = userRepository.getOne(id);
			
			updateData(objMonitorado, obj);
			
			return userRepository.save(objMonitorado);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}


	private void updateData(User objMonitorado, User obj) {
		objMonitorado.setNome(obj.getNome());
		objMonitorado.setEmail(obj.getEmail());
		objMonitorado.setPhone(obj.getPhone());

	}
	
	

}
