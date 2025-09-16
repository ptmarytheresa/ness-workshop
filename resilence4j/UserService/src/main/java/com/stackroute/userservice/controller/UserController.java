package com.stackroute.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.entity.UserProfile;
import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UseridNotFoundException;
import com.stackroute.userservice.service.UserService;

@RestController
@RequestMapping("user/api/v1")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> adduser(@RequestBody UserProfile user) throws UserAlreadyExistException
	{
	  UserProfile userobj=userservice.registerUser(user);
	  
	  return new ResponseEntity<UserProfile>(userobj,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewbyemail/{email}")
	public ResponseEntity<?> view(@PathVariable ("email") String email)
	{
		UserProfile user=userservice.viewUserByEmail(email);
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<?> view(@PathVariable ("id") int id) throws UseridNotFoundException
	{
		boolean result=userservice.deleteUser(id);
		return new ResponseEntity(result,HttpStatus.OK);
	}
}
