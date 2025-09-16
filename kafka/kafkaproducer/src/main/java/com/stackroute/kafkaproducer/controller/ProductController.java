package com.stackroute.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.kafkaproducer.model.Product;
import com.stackroute.kafkaproducer.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	ProductService pservice;
	
	
	@PostMapping("/product/add")
	public ResponseEntity addproduct(@RequestBody Product prd)
	{
		
		Product prdresult=pservice.addProduct(prd);
		
		return new ResponseEntity(prdresult,HttpStatus.CREATED);
		
	}
}
