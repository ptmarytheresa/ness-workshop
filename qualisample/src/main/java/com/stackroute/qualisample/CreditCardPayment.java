package com.stackroute.qualisample;

import org.springframework.stereotype.Component;

@Component
class CreditCardPayment implements PaymentService {
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}