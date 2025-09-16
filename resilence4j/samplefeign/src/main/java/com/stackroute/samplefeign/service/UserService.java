package com.stackroute.samplefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.samplefeign.model.UserProfile;

@FeignClient("userservice")
public interface UserService {

	@RequestMapping(method=RequestMethod.GET,value="/user/api/v1/viewbyemail/{emailid}",consumes="application/json")
    public UserProfile getUserbyemail(@PathVariable("emailid") String emailid);
}
