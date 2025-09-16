
package com.stackroute.kafkaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stackroute.kafkaconsumer.model.ProductDTO;

@Service
public class ConsumerService {
	
	//any repository
	@Autowired
	Gson gson;
	
	@KafkaListener(topics="nessproduct",groupId="nessgroup")
	public void datafromProducer(String result)
	{
		ProductDTO dtoobj=gson.fromJson(result, ProductDTO.class);
		System.out.println("Recored Retrieved from producer is " + dtoobj);
	}
	
	

}
