package com.algomesti.bank.model.payment;

import com.algomesti.bank.model.Account;
import com.algomesti.bank.model.Person;

import java.math.BigDecimal;

public class PayStub implements Bill {

    private final Person employee;
    private final BigDecimal hourlyRate;
    private final int hoursWorked;
    private boolean paid = false;

    public Person getEmployee() {
        return employee;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public PayStub(Person employee, BigDecimal hourlyRate, int hoursWorked) {

        this.employee = employee;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;

    }

    @Override
    public BigDecimal getTotalAmount() {
        return this.hourlyRate.multiply(BigDecimal.valueOf(hoursWorked));
    }

    @Override
    public boolean isPaid() {
        return this.paid;
    }

    @Override
    public void settlePayment() {

        this.paid = true;
        System.out.println("Contracheque Pago: "+ this.getTotalAmount());

    }


}
