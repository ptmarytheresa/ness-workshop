package com.stackroute.javabased;

public class Product {
	
	String pname;
	int price;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", price=" + price + "]";
	}
	

}
