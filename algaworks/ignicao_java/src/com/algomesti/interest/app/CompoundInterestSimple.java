package com.algomesti.interest.app;

import java.math.BigDecimal;

public class CompoundInterestSimple {

    private final static int DEFAULT_MONTHS = 12;
    private final static BigDecimal DEFAULT_INITIAL_AMOUNT = BigDecimal.valueOf(1000);
    private final static BigDecimal DEFAULT_TARGET_AMOUNT = BigDecimal.valueOf(2000);
    private final static BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.8);

    private final static BigDecimal CEM = BigDecimal.valueOf(100);
    private final static int SCALE_PROCESS = 10;
    private final static int SCALE_SHOW = 2;

    public static void processByMonthSimple(double inicialAmount, double interestRate, int durationInMonths) {

        double accumulatedAmountDouble = inicialAmount;
        int year = 0;
        int month = 0;
        for (int countMonth = 1; countMonth <= durationInMonths; countMonth++) {
            month ++;
            if(year == 0 || month > 12) {
                month = 1;
                year ++;
                System.out.printf("%n%n====> ANO: %d%n", year);
            }

            accumulatedAmountDouble += accumulatedAmountDouble * interestRate / 100;
            System.out.printf("Mês: %d - R$ %.2f%n", month, accumulatedAmountDouble);

        }

    }
    public static void processTargetSimple(double inicialAmount, double interestRate, double targetAmount) {


        int month = 0;
        int year = 0;
        double accumulatedAmount = inicialAmount;

        while (accumulatedAmount <= targetAmount) {

            month ++;
            if(year == 0 || month > 12) {
                month = 1;
                year ++;
                System.out.printf("%n%n====> ANO: %d", year);
            }

            accumulatedAmount += accumulatedAmount * interestRate / CEM.doubleValue();

            System.out.printf("%nMes: %d = %.2f", month, accumulatedAmount);

        }
    }

}
