package com.stackroute.kafkaconsumer.model;

public class ProductDTO {

	
	String productname;
	int price;
	
	public String getProductname() {
		return productname;
	}
	@Override
	public String toString() {
		return "ProductDTO [productname=" + productname + ", price=" + price + "]";
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
	
}
