package com.algomesti.bank.app;

import com.algomesti.bank.exception.InsufficientFundsException;
import com.algomesti.bank.model.*;
import com.algomesti.bank.model.atm.Atm;
import com.algomesti.bank.model.payment.Bill;
import com.algomesti.bank.model.payment.PayStub;
import com.algomesti.bank.model.payment.PaymentSlip;
import com.algomesti.bank.model.payment.ReversiblePayment;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws InsufficientFundsException {

        Person alexandre = new Person("1111111111", "Alexandre Gomes");
        alexandre.setPersonType(PersonType.INDIVIDUAL);

        Person cristiane = new Person("2222222222", "Cristiane Renno");
        cristiane.setPersonType(PersonType.INDIVIDUAL);

        Person carlos    = new Person("3333333333", "Carlos Gomes");
        carlos.setPersonType(PersonType.COMPANY);

        Person carla     = new Person("4444444444", "Carla Gomes");
        carla.setPersonType(PersonType.COMPANY);

        CheckingAccount accountAlexandre = new CheckingAccount(111111, 11122334, alexandre);
        accountAlexandre.deposit(BigDecimal.valueOf(15_000));
        accountAlexandre.withDraw(BigDecimal.valueOf(3_000));
        Atm.printBalance(accountAlexandre);

        /*InvestimentCheckingAccount accountCarlos = new InvestimentCheckingAccount(222222, 55667788, carlos);
        accountCarlos.deposit(BigDecimal.valueOf(25_000));
        accountCarlos.deposit(BigDecimal.valueOf(5_000));
        accountCarlos.withDraw(BigDecimal.valueOf(14_000));
        accountCarlos.withDraw(BigDecimal.valueOf(2_000));
        accountCarlos.withDraw(BigDecimal.valueOf(1_000));
        Atm.printBalance(accountCarlos);

        InvestimentCheckingAccount accountCristiane = new InvestimentCheckingAccount(333333, 44556677, cristiane);
        accountCristiane.deposit(BigDecimal.valueOf(1000));
        accountCristiane.credit(BigDecimal.valueOf(10));
        Atm.printBalance(accountCristiane);

        SpecialCheckingAccount accountCarla = new SpecialCheckingAccount(55555, 55667788, carla, BigDecimal.valueOf(500));
        accountCarla.deposit(BigDecimal.valueOf(1_000));
        accountCarla.withDraw(BigDecimal.valueOf(1_500.00));
        Atm.printBalance(accountCarla);*/

        Atm.printBalance(accountAlexandre);
        Bill payStub = new PayStub(carla, BigDecimal.valueOf(35.2), 50);
        Atm.pay(payStub, accountAlexandre);
        Atm.printBalance(accountAlexandre);
        payStub.printReceipt();

        ReversiblePayment paymentSlip = new PaymentSlip(carla, BigDecimal.valueOf(365.43));
        Atm.pay(paymentSlip, accountAlexandre);
        Atm.printBalance(accountAlexandre);
        paymentSlip.printReceipt();

        Atm.reversePayment(paymentSlip, accountAlexandre);
        Atm.printBalance(accountAlexandre);
        paymentSlip.printReceipt();

    }

}
