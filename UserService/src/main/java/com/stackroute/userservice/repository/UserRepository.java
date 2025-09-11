package com.stackroute.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.userservice.entity.UserProfile;

@Repository

public interface UserRepository  extends JpaRepository<UserProfile,Integer>
{
	//jpql
	UserProfile findByEmailIdAndActive(String emailid,String active);
	
	UserProfile findByEmailId(String email);

	List<UserProfile> findByAddr(String addr);
}
