package com.stackroute.javabased;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Bill implements InitializingBean,DisposableBean {

	int billNo;
	String customername;
	
	@Autowired
	List<Product> products;
	
	
	@Autowired

 	Product productnew;
	

	public Product getProductnew() {
		return productnew;
	}
	public void setProductnew(Product productnew) {
		this.productnew = productnew;
	}
	
	
	
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Bill [billNo=" + billNo + ", customername=" + customername + ", products=" + products + "]";
	}
	public void destroy() throws Exception {

System.out.println("Bill bean is getting destroyed ");		
	}
	public void afterPropertiesSet() throws Exception {
		this.setCustomername("Mary");
		
	}
	
}
