package com.algomesti.bank.model.payment;

import com.algomesti.bank.model.Person;

import java.math.BigDecimal;

public class PaymentSlip implements Bill, ReversiblePayment {

    private Person person;
    private BigDecimal totalAmount;
    private boolean paid = false;

    public PaymentSlip(Person person, BigDecimal totalAmount) {

        this.person = person;
        this.totalAmount = totalAmount;

    }

    @Override
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    @Override
    public boolean isPaid() {
        return this.paid;
    }

    @Override
    public void reversePayment() {

        this.paid = false;

    }

    @Override
    public void settlePayment() {

        this.paid = true;
        System.out.println("Boleto Pago: "+ this.getTotalAmount());

    }
}
