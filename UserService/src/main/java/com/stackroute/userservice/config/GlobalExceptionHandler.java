package com.stackroute.userservice.config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UseridNotFoundException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<?> handler1(HttpServletResponse  res)
	{
		String data="User id is already exist";
		return new ResponseEntity("User not Added",HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(UseridNotFoundException.class)
	public ResponseEntity<?> handler2(HttpServletResponse  res)
	{
		String data="User id not presenet";
		return new ResponseEntity("User not delete",HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerRequest(MethodArgumentNotValidException excep )
	{
		
		Map<String,Object> resbody=new HashMap();
		System.out.println(excep.getBindingResult());
	List<String> errors=excep.getBindingResult().getFieldErrors().stream()
		 	.map( obj-> obj.getDefaultMessage()).collect(Collectors.toList());
	
	resbody.put("Errors",errors);
	return new ResponseEntity(resbody,HttpStatus.NOT_FOUND);
		
		
		
	}
	
}
