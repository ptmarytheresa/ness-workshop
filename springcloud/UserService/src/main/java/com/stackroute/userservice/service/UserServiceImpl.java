package com.stackroute.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.entity.UserProfile;
import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UseridNotFoundException;
import com.stackroute.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserProfile registerUser(UserProfile user) throws UserAlreadyExistException {
		
		Optional<UserProfile> optuser=repo.findById(user.getUserid());
		
		if (optuser.isPresent())
			throw new UserAlreadyExistException("userid is not available");
		else
			
		return repo.save(user);
	}

	@Override
	public boolean deleteUser(int userid)  throws UseridNotFoundException{
	Optional<UserProfile> optuser=repo.findById(userid);
	
	if (optuser.isEmpty())
		throw new UseridNotFoundException("User Does nto exist for update");
	
		repo.deleteById(userid);
 		return true;
	}

	@Override
	public UserProfile updateUser(UserProfile user) throws UseridNotFoundException {
		
		Optional<UserProfile> optuser=repo.findById(user.getUserid());
		
		if (optuser.isPresent())
		{
			return repo.save(user);
		}
		else
		throw new UseridNotFoundException("User Does nto exist for update");
	}

	@Override
	public UserProfile viewUserByEmail(String email) {
		
		Optional<UserProfile> optuser=repo.findByEmailId(email);
		if (optuser.isPresent())
 		return optuser.get();
		else
			return null;
	}

	@Override
	public List<UserProfile> viewByAddr(String addr) {
 		return repo.findByAddr(addr);
	}

}
