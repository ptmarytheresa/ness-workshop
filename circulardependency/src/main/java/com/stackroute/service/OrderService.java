package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final UserService userService;

    @Autowired
    public OrderService(UserService userService) {
        this.userService = userService;
    }


    
    public List<String> getOrders() {
        // Simulate fetching orders
        List<String> orderList = new ArrayList<>();
        orderList.add("Order1");
        orderList.add("Order2");
        return orderList;
    }

     
    public String getOrderUser() {
        return "Ordered user: " + userService.getUserDetails();
    }
}