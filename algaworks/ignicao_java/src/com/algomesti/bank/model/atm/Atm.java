package com.algomesti.bank.model.atm;

import com.algomesti.bank.model.Account;
import com.algomesti.bank.model.payment.Bill;
import com.algomesti.bank.model.payment.ReversiblePayment;

public class Atm {

    public static void printBalance(Account account) {

        System.out.printf("%nCliente: %s:%s", account.getClient().getDocument(), account.getClient().getDocument());
        System.out.printf("%nAgência: %s", account.getBranchNumber());
        System.out.printf("%nConta: %s", account.getNumber());
        System.out.printf("%nSaldo: %s", account.getBalanceAvailable());
        System.out.printf("%n");

    }

    public static void pay(Bill bill, Account account) {

        if(bill.isPaid()) {
            throw new IllegalStateException("O documento já está pago");
        }
        account.withDraw(bill.getTotalAmount());
        bill.settlePayment();

    }

    public static void reversePayment(ReversiblePayment bill, Account account) {

        if(!bill.isPaid()) {
            throw new IllegalStateException("Boleto não foi pago, logo nao pode ser estornado");
        }
        account.deposit(bill.getTotalAmount());
        bill.reversePayment();

    }

}
