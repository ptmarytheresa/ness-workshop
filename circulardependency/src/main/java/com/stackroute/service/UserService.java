package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
    private String userName="Mary";
    private final OrderService orderService;

    @Autowired
    public UserService(OrderService orderService) {
        this.orderService = orderService;
    }


    
    public String getUserDetails() {
 
        return this.userName;
    }
 

    public String getUserOrders() {
        return "User orders: " + orderService.getOrders();
    }
}
