package com.algomesti.bank.model;

import com.algomesti.bank.exception.InsufficientFundsException;

import java.math.BigDecimal;

public abstract class Account {

    private int branchNumber;
    private int number;
    private Person person;
    private BigDecimal balance = BigDecimal.ZERO;

    public abstract void debitMonthFee();

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setClient(Person person) {
        this.person = person;
    }

    public int getNumber() {
        return number;
    }

    public Person getClient() {
        return person;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal value) {

        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Não pode depositar valores negativos");
        }
        this.balance = this.balance.add(value);
        System.out.printf("%n[%s-%s] Depositou: R$ %s  ",this.getClient().name(), this.getNumber(), value);

    }
    public void withDraw(BigDecimal value) throws InsufficientFundsException {

        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Não pode sacar valores negativos");
        }

        if(value.compareTo(getBalanceAvailable()) > 0 ) {
            throw new InsufficientFundsException("Saldo Insuficiente");
        }

        this.balance = this.balance.subtract(value);

        System.out.printf("%n[%s-%s] Sacou: R$ %s  ",this.getClient().name(), this.getNumber(), value);

    }

    public BigDecimal getBalanceAvailable() {
        return getBalance();
    }

}
