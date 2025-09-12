package com.stackroute.securitydb.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.securitydb.model.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer>{

	Optional<UserInfo> findByUsername(String name);

}
