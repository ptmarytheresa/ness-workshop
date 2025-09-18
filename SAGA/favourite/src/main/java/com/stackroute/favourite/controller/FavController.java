package com.stackroute.favourite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.stackroute.favourite.model.Favbackup;
import com.stackroute.favourite.model.Favourite;
import com.stackroute.favourite.model.RollbackEvent;
import com.stackroute.favourite.service.FavService;
 
@RestController
@RequestMapping("/favourite")
public class FavController {
	
	@Autowired
	FavService service;
	
	String message="";
	
	@Autowired
	Gson gson;
	
	@Autowired
	KafkaTemplate<String,String> kafkatemp;
	
	
	
	@KafkaListener(topics="rollbacktopic",groupId="nessgroup1")
	public void rollingBack(String data)
	{
		RollbackEvent obj=gson.fromJson(data,RollbackEvent.class);
		System.out.println("Message from Recommendation");
		System.out.println(obj);
		message=obj.getReason();
		// compensation actions in favourite table or favbackup table
//		service.deleteFav
		// or add this rollbackevent obj in Notifcation table 
	}
	
		@PostMapping("/add")
		public ResponseEntity add(@RequestBody Favourite fav)
		{
			Favourite result=service.addFav(fav);
			
			Favbackup domainobj=new Favbackup();
			
			 domainobj.setAuthor(fav.getFavnews().getAuthor());
			 domainobj.setEmailId(fav.getEmailId());
			 domainobj.setSourceName(fav.getFavnews().getSourceName());
			 
			//trigger / publish  the event in kafka topic
			kafkatemp.send("recomtopic", gson.toJson(domainobj));
	
			return new ResponseEntity(result,HttpStatus.CREATED);
		
			
		}
		
	 
	 
	
	@GetMapping("/view/{email}")
	
	public ResponseEntity viewall(@PathVariable("email") String mail)
	{
		List<Favourite> favlist=service.viewByEmail(mail);
		return new ResponseEntity(favlist,HttpStatus.OK);
	}

}
