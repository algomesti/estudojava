package com.algomesti.interest.app;

import java.math.BigDecimal;
import java.util.Scanner;

public class CompoundInterest {

    private final static int DEFAULT_MONTHS = 12;
    private final static BigDecimal DEFAULT_INITIAL_AMOUNT = BigDecimal.valueOf(1000);
    private final static BigDecimal DEFAULT_TARGET_AMOUNT = BigDecimal.valueOf(2000);
    private final static BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.8);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int type = InputScanner.readIntWithDefault(scanner, "Escreva 1 para Por mes e 2 para meta: ", 1);

        BigDecimal inicialAmount = InputScanner.readBigDecimalWithDefault(scanner, "Valor Inicial: ", DEFAULT_INITIAL_AMOUNT);
        BigDecimal interestRate = InputScanner.readBigDecimalWithDefault(scanner, "Taxa Mensal: ",DEFAULT_INTEREST_RATE);

        int months;

        switch (type) {
            case 1:
                months = InputScanner.readIntWithDefault(scanner, "Quantidade de meses: ",DEFAULT_MONTHS);
                processByMonth(inicialAmount, interestRate, months);
                break;
            case 2:
                BigDecimal targetAmount = InputScanner.readBigDecimalWithDefault(scanner, "Meta a ser alcançada: ", DEFAULT_TARGET_AMOUNT);
                processByTarget(inicialAmount, interestRate, targetAmount);

        }

    }

    private static void processByMonth(BigDecimal inicialAmount, BigDecimal interestRate, int durationInMonths) {
        System.out.printf("%n%nP O R   M E S");
        System.out.printf("%n--- DOUBLE");
        CompoundInterestSimple.processByMonthSimple(inicialAmount.doubleValue(), interestRate.doubleValue(), durationInMonths);
        System.out.printf("%n--- DECIMAL");
        CompoundInterestDecimal.processByMonthBigDecimal(inicialAmount, interestRate, durationInMonths);

    }
    private static void processByTarget(BigDecimal inicialAmount, BigDecimal interestRate, BigDecimal targetAmount) {

        System.out.printf("%n%nP O R   T A R G E T");
        System.out.printf("%n--- DOUBLE");
        CompoundInterestSimple.processTargetSimple(inicialAmount.doubleValue(), interestRate.doubleValue(), targetAmount.doubleValue());
        System.out.printf("%n--- DECIMAL");
        CompoundInterestDecimal.processTargetBigDecimal(inicialAmount, interestRate, targetAmount);

    }

}
