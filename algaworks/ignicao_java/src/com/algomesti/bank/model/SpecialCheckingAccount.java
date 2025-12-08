package com.algomesti.bank.model;

import java.math.BigDecimal;

public class SpecialCheckingAccount extends Account {

    private final BigDecimal MONTH_FEE = BigDecimal.valueOf(50.05);
    private BigDecimal limit;

    public SpecialCheckingAccount(int branchNumber, int number, Person person, BigDecimal limit) {

        this.setBranchNumber(branchNumber);
        this.setNumber(number);
        this.setClient(person);
        this.limit = limit;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public BigDecimal getBalanceAvailable() {
        return getBalance().add(limit);
    }

    @Override
    public void debitMonthFee() {
        if(getBalanceAvailable().compareTo(BigDecimal.valueOf(20_000)) > 0)  {
            return;
        }
        withDraw(MONTH_FEE);
    }

}