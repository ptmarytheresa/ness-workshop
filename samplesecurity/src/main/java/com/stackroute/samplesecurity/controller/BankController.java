package com.stackroute.samplesecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banking")
public class BankController {

	
	@GetMapping("/about")
	public ResponseEntity<?> getAbout()
	{
		return new ResponseEntity<String>("Hello all, welcome to the banking home page",HttpStatus.OK);
	}
	
	
	@GetMapping("/user/add")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity register()
	{
		
		//some code for adding user
		return new ResponseEntity("Hi Admin, you can add user  ",HttpStatus.OK);
	}
	
	@GetMapping("/api/viewdata")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	
	public ResponseEntity viewdata()
	{
		return new ResponseEntity("hi Manager, you can access this endpoint ",HttpStatus.OK);
	}
	
}
