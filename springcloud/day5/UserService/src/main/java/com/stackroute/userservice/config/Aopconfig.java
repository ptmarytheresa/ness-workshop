package com.stackroute.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Aopconfig {
	
	
	@Bean
	public UserAspect getUser()
	{
		return new UserAspect();
	}

}
