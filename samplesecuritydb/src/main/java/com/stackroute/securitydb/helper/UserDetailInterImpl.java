package com.stackroute.securitydb.helper;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stackroute.securitydb.model.UserInfo;



public class UserDetailInterImpl implements UserDetails {

	String name,password;
	List<GrantedAuthority> authorities;
	
	
	public UserDetailInterImpl(UserInfo uinfo)
	{
		name=uinfo.getUsername();
		password=uinfo.getPassword();
 
		authorities = Arrays.stream(uinfo.getRoles().split(","))
		        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim().toUpperCase())) 
		           .collect(Collectors.toList());
		
		authorities.forEach(System.out::println);		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
 
		return authorities;
	}

	@Override
	public String getPassword() {
 
		return password;
	}

	@Override
	public String getUsername() {
 
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
