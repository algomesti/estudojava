package com.algomesti.bank.app;

import com.algomesti.bank.model.Account;
import com.algomesti.bank.model.Bank;
import com.algomesti.bank.model.Person;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {


        Bank bank = new Bank();

        bank.getAccount(1111, 5555555).ifPresent(account -> System.out.println(account.getBalance()));
        System.out.println();

        bank.getAccounts().forEach(System.out::println);
        System.out.println();

        bank.getAccounts().stream()
                .filter(account -> account.getBranchNumber() < 3333)
                .map(Account::getClient)
                .distinct()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
        System.out.println();

        bank.getAccounts().stream()
                .filter(account -> account.getBranchNumber() < 3333)
                .map(Account::getClient)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println();

        System.out.println(
                "Saldo: " + bank.getAccounts().stream()
                        .map(Account::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );


    }

}
