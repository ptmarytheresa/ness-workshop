package com.stackroute.securitydb.helper;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stackroute.securitydb.model.UserInfo;
import com.stackroute.securitydb.repo.UserRepo;

 

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<UserInfo> objuserinfo=repo.findByUsername(username);
		
		
return objuserinfo.map(UserDetailInterImpl::new)
			.orElseThrow(()->new UsernameNotFoundException("username is invalid"))	;

	 
	}

}
