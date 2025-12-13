package com.algomesti.bank.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CheckingAccount extends Account {

    private final BigDecimal MONTH_FEE = BigDecimal.valueOf(15.05);

    public CheckingAccount(int branchNumber, int number, Person person) {

        Objects.requireNonNull(person, "Cliente é obrigatório");

        this.setBranchNumber(branchNumber);
        this.setNumber(number);
        this.setClient(person);
    }

    @Override
    public void debitMonthFee() {
        if(getBalanceAvailable().compareTo(BigDecimal.valueOf(10_000)) > 0)  {
            return;
        }
        withDraw(MONTH_FEE);
    }
}
