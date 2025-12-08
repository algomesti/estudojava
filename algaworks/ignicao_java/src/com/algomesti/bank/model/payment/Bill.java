package com.algomesti.bank.model.payment;

import com.algomesti.bank.model.Account;

import java.math.BigDecimal;

public interface Bill {

    BigDecimal getTotalAmount();
    boolean isPaid();
    void settlePayment();

    default void printReceipt() {

        System.out.println();
        System.out.println("RECIBO");
        System.out.println("Valor Total: " + getTotalAmount());
        System.out.println("Pago: " + isPaid());

    }

}
