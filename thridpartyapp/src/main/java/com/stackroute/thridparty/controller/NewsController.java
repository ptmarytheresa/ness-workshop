package com.stackroute.thridparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.stackroute.thridparty.model.NewsBase;
import com.stackroute.thridparty.service.NewsService;

@RestController
public class NewsController {

	
	
	@Value("${message}")
	String status;
	
	@Autowired
	NewsService nservice;
	
	
	@GetMapping("/message")
	public ResponseEntity getmessage()
	{
		return new ResponseEntity("message is  " + status, HttpStatus.OK);
	}
	
	@RequestMapping(value="/viewnews",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getData()
	{
		NewsBase newsresult =nservice.getNews();
		
		return new ResponseEntity(newsresult.getArticles(),HttpStatus.OK);
		
		
	}
}
