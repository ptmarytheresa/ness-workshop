package com.stackroute.samplefeign.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.samplefeign.model.Article;
import com.stackroute.samplefeign.model.Favourite;
import com.stackroute.samplefeign.model.UserProfile;
import com.stackroute.samplefeign.service.FavService;
import com.stackroute.samplefeign.service.NewsService;
import com.stackroute.samplefeign.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

 
@RestController
@RequestMapping("/client/customer/")

public class UserController {
	
	@Autowired
	NewsService newsservice;
	
	@Autowired
	UserService userservice;
	
	@GetMapping("viewnews")
   public ResponseEntity<?> getnews()
   {
	List<Article> articles=	newsservice.getAllNews();
	return new ResponseEntity(articles,HttpStatus.OK);
   }
	
	
	
	@CircuitBreaker(name="myinstance",fallbackMethod="handleFailure")
	@RateLimiter(name = "myratelimiter", fallbackMethod = "rateLimitFallback")
	
	@GetMapping("viewuser/{emailid}")
	
	 public ResponseEntity<?> getuserbyemail(@PathVariable("emailid") String email)
	   {
		UserProfile userprofile=	userservice.getUserbyemail(email);
		return new ResponseEntity(userprofile,HttpStatus.OK);
	   }
	
    public ResponseEntity<?> handleFailure(String email, Exception e) {
        return new ResponseEntity<>(
                "Service is down, please try again later. " + LocalDateTime.now(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
  
    public ResponseEntity<?> rateLimitFallback(String email, Exception e) {
        return new ResponseEntity<>(
                "Too many requests - please retry after some time. " + LocalDateTime.now(),
                HttpStatus.TOO_MANY_REQUESTS
        );
    }
	
//
//	@CircuitBreaker(name="myinstance",fallbackMethod="handleFailure")
//	@GetMapping("myfavourite/{email}")
//	public ResponseEntity<?> myfav(@PathVariable("email") String email)
//	{
//		List<Favourite> favlist=favservice.viewFavorite(email);
//		return new ResponseEntity(favlist,HttpStatus.OK);
//	}
//	

//	

}
