package com.stackroute.javabased.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import com.stackroute.javabased.BeanMonitor;
import com.stackroute.javabased.Bill;
import com.stackroute.javabased.Product;

@Configuration
public class MyBeanconfig {
	
	@Bean("product1")
 
 	@Order(2)
	public Product getProduct()
	{
		Product prd1=new Product();
		prd1.setPname("Icecream");
		prd1.setPrice(450);
		return prd1;
	}
	
	
	@Bean("product2")
	@Order(1)
	public Product getProduct2()
	{
		Product prd2=new Product();
		prd2.setPname("Soup");
		prd2.setPrice(600);
		return prd2;
	}
	@Bean("billbean")
	public Bill getBill()
	{
		Bill bobj=new Bill();
		bobj.setBillNo(10);
		bobj.setCustomername("Rutuja");
	
		return bobj;
	}
	
	@Bean("monitorbean")
	public BeanMonitor getMonitored()
	{
		return new BeanMonitor();
	}

}
