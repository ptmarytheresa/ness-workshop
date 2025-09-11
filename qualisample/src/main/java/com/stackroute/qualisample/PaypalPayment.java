package com.stackroute.qualisample;

import org.springframework.stereotype.Component;

@Component
class PayPalPayment implements PaymentService {
    public void processPayment() {
        System.out.println("Processing PayPal Payment");
    }
}