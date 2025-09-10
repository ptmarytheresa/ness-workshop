package com.stackroute.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.javabased.configuration.MyBeanconfig;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appcontext=new AnnotationConfigApplicationContext(MyBeanconfig.class);
        Bill bobj=appcontext.getBean("billbean",Bill.class);
        System.out.println(bobj);
//        System.out.println(bobj.getProductnew().toString());
    }
}
