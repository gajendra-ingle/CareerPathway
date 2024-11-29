package com.jbk.exceptions;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.dto.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> invalidData(MethodArgumentNotValidException e) {
		HashMap<String, String> error = new HashMap<String, String>();
		List<FieldError> fieldErrors = e.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			error.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return error;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ExceptionResponse resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setPath(request.getRequestURI());
		exceptionResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return exceptionResponse;
	}

	
}
