package com.algomesti.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class InvestimentCheckingAccount extends Account {

    public InvestimentCheckingAccount(int branchNumber, int number, Person person) {
        Objects.requireNonNull(person, "Cliente é obrigatório");

        this.setBranchNumber(branchNumber);
        this.setNumber(number);
        this.setClient(person);

    }

    public void credit(BigDecimal interestRate) {
        BigDecimal interest = getBalance().multiply(interestRate.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP));
        deposit(interest);
    }

    @Override
    public void debitMonthFee() {

        return;

    }
}
