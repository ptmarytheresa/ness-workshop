package com.stackroute.qualisample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages = "com.stackroute.qualisample") 
public class App 
{
	
    public static void main( String[] args )
    {
    	
    	 AnnotationConfigApplicationContext context = 
    	            new AnnotationConfigApplicationContext(App.class);
    	        
    	        PaymentProcessor processor = context.getBean(PaymentProcessor.class);
    	        processor.makePayment();
    	        
    	        context.close();
    }
}
