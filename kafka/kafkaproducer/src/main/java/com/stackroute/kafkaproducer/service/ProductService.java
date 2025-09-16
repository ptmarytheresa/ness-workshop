package com.stackroute.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stackroute.kafkaproducer.model.Product;
import com.stackroute.kafkaproducer.model.ProductDTO;
@Service
public class ProductService {
 
	@Autowired
	Gson gson;
	
	@Autowired
	KafkaTemplate<String,String> kafkatemp;
	
	
	
	public Product addProduct(Product product)
	{
		// write logic to store in database
		
		ProductDTO productdto=new ProductDTO();
		
		
		productdto.setProductname(product.getProductname());
		productdto.setPrice(product.getPrice());
		
		// sending dto to topics via kafka
		kafkatemp.send("nessproduct", gson.toJson(productdto));
		
		
		return product;
		
	}
	
}
