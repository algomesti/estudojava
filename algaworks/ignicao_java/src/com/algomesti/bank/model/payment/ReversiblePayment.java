package com.algomesti.bank.model.payment;

public interface ReversiblePayment extends Bill {

    void reversePayment();

}
