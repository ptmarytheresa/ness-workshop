package com.stackroute.securitydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.securitydb.model.UserInfo;
import com.stackroute.securitydb.service.UserinfoserviceImpl;

@RestController
public class SampleController {
	@Autowired
	UserinfoserviceImpl service;
	
	
	@PostMapping("/home/register")
	
	public ResponseEntity adduser(@RequestBody UserInfo user)
	{
		String result=service.addUser(user);
		return new ResponseEntity("User Added Successfully",HttpStatus.CREATED);
	}
		
	
	@GetMapping("/users/viewemployee")
	
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity viewemp()
	{
		List<UserInfo> users=service.getallUsers();
		return new ResponseEntity(users , HttpStatus.OK);
	}
	
	@GetMapping("/users/dashboard")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity viewall()
	{
		
		return new ResponseEntity("in dashboard : details are : ..." , HttpStatus.OK);

	}
	
	// add delete and update end points
	

}
