package com.educando.course.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educando.course.course.services.exceptions.DataBaseException;
import com.educando.course.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){
		String error = "Resource Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err  = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());;
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException ex, HttpServletRequest request){
		String error = "Resource Not Found";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err  = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());;
		return ResponseEntity.status(status).body(err);
	}
	
	
	
}
