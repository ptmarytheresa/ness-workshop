package com.stackroute.kafkaproducer.model;

public class Product {

	  int id;
	  String productname;
	  int price;
	  String feedback;
	  
	  public Product()
	  {
		  
	  }
	public Product(int id, String productname, int price, String feedback) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.feedback = feedback;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	  
	
}
