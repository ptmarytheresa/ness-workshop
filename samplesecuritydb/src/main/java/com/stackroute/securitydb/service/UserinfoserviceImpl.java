package com.stackroute.securitydb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.securitydb.model.UserInfo;
import com.stackroute.securitydb.repo.UserRepo;
 

@Service
public class UserinfoserviceImpl {

	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	public String addUser(UserInfo userinfo)
	{
		userinfo.setPassword(encoder.encode(userinfo.getPassword()));
	  repo.save(userinfo);
	  
	  return "User Added";
	}
	
	public List<UserInfo> getallUsers()
	{
		return repo.findAll();
	}
}
