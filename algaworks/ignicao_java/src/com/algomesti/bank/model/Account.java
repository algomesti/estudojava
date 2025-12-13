package com.algomesti.bank.model;

import com.algomesti.bank.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;

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
       // System.out.printf("%n[%s-%s] Depositou: R$ %s  ",this.getClient().getName(), this.getNumber(), value);

    }
    public void withDraw(BigDecimal value) throws InsufficientFundsException {

        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Não pode sacar valores negativos");
        }

        if(value.compareTo(getBalanceAvailable()) > 0 ) {
            throw new InsufficientFundsException("Saldo Insuficiente");
        }

        this.balance = this.balance.subtract(value);

        //System.out.printf("%n[%s-%s] Sacou: R$ %s  ",this.getClient().getName(), this.getNumber(), value);

    }

    public String getId() {
        return String.format("%s/%s", branchNumber, number);
    }

    public BigDecimal getBalanceAvailable() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Account{" +
                "branchNumber=" + branchNumber +
                ", number=" + number +
                ", person=" + person +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;
        if(obj == null) return false;
        if(!obj.getClass().equals(this.getClass())) return false;

        Account newAccount = (Account) obj;
        return newAccount.getId().equals(this.getId());

    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());

    }

}
