package com.stackroute.userservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="aboutme")
public class CustomEndpoint {
	
	
	@ReadOperation
	public Map<String,String> customEndpoint()
	{
		Map<String,String> result=new HashMap();
		result.put("helpline: ","This is userservice api, to run use localhost:9292/swagger-ui/index");
		return result;
	}

}
