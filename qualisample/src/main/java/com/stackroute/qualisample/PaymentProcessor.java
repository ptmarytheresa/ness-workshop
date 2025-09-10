package com.stackroute.qualisample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface PaymentService {
    void processPayment();
}
@Component

class CreditCardPayment implements PaymentService {
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}
@Component

class PayPalPayment implements PaymentService {
    public void processPayment() {
        System.out.println("Processing PayPal Payment");
    }
}
@Component
class PaymentProcessor {
    private final PaymentService paymentService;

    @Autowired
    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment() {
        paymentService.processPayment();
    }
}
