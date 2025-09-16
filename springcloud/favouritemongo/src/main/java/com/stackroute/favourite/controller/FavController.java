package com.stackroute.favourite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
 
import com.stackroute.favourite.model.Favourite;
import com.stackroute.favourite.service.FavService;

@RestController
@RequestMapping("/favourite")
public class FavController {
	
	@Autowired
	FavService service;
	
	
 
	
	
	@PostMapping("/add")
	public ResponseEntity add(@RequestBody Favourite fav)
	{
		Favourite result=service.addFav(fav);
		
 
		 
	 
		
		return new ResponseEntity(result,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/view/{email}")
	
	public ResponseEntity viewall(@PathVariable("email") String mail)
	{
		List<Favourite> favlist=service.viewByEmail(mail);
		return new ResponseEntity(favlist,HttpStatus.OK);
	}

}
