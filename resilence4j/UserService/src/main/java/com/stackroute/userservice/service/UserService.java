package com.stackroute.userservice.service;

import java.util.List;

import com.stackroute.userservice.entity.UserProfile;
import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UseridNotFoundException;
 
public interface UserService {

	
	UserProfile registerUser(UserProfile user) throws UserAlreadyExistException;
	boolean deleteUser(int id) throws UseridNotFoundException;
	UserProfile updateUser(UserProfile user) throws UseridNotFoundException;
	UserProfile viewUserByEmail(String email);
	List<UserProfile> viewByAddr(String addr);
	boolean deletebyemailId(String userid) throws UseridNotFoundException;
}
