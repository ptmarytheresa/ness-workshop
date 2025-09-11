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
