package com.algomesti.bank.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private final Set<Account> accountList =  new LinkedHashSet<>();

    public Bank() {

        Person carlos    = new Person("111111111", "Carlos Gomes");
        Person lourdes   = new Person("222222222", "Lourdes Gomes");
        Person carla     = new Person("333333333", "Carla Gomes");
        Person jaqueline = new Person("444444444", "Jaqueline Gomes");
        Person danielle  = new Person("555555555", "Danielle Gomes");
        Person priscila  = new Person("666666666", "Priscila Gomes");
        Person alexandre = new Person("777777777", "Alexandre Gomes");
        Person cristiane = new Person("888888888", "Cristiane Gomes");

        Account account01 = new CheckingAccount(1111, 1111111, carlos);
        Account account02 = new CheckingAccount(1111, 2222222, lourdes);
        Account account03 = new CheckingAccount(2222, 3333333, jaqueline);
        Account account04 = new CheckingAccount(2222, 4444444, danielle);
        Account account05 = new CheckingAccount(1111, 5555555, alexandre);
        Account account06 = new SpecialCheckingAccount(3333,6666666, carlos, BigDecimal.valueOf(10_000));
        Account account07 = new SpecialCheckingAccount(1111,7777777, carla, BigDecimal.valueOf(4_000));
        Account account08 = new SpecialCheckingAccount(3333,8888888, priscila, BigDecimal.valueOf(1_000));
        Account account09 = new InvestimentCheckingAccount(1111, 9999999, cristiane);
        Account account10 = new InvestimentCheckingAccount(2222, 1212121, carlos);
        Account account11 = new InvestimentCheckingAccount(3333, 1313131, alexandre);

        account01.deposit(BigDecimal.valueOf(120));
        account02.deposit(BigDecimal.valueOf(130));
        account03.deposit(BigDecimal.valueOf(140));
        account04.deposit(BigDecimal.valueOf(150));
        account05.deposit(BigDecimal.valueOf(160));
        account06.deposit(BigDecimal.valueOf(170));
        account07.deposit(BigDecimal.valueOf(180));
        account08.deposit(BigDecimal.valueOf(190));
        account09.deposit(BigDecimal.valueOf(200));
        account10.deposit(BigDecimal.valueOf(210));
        account11.deposit(BigDecimal.valueOf(220));

        accountList.add(account01);
        accountList.add(account02);
        accountList.add(account03);
        accountList.add(account04);
        accountList.add(account05);
        accountList.add(account06);
        accountList.add(account07);
        accountList.add(account08);
        accountList.add(account09);
        accountList.add(account10);
        accountList.add(account11);

    }

    public Optional<Account> getAccount(int branchNumber, int number) {

        return accountList
            .stream()
            .filter(account -> (branchNumber == account.getBranchNumber())  && (number == account.getNumber()))
            .findFirst();

    }

    public Set<Account> getAccounts(Person person) {

        return accountList
                .stream()
                .filter(account -> person.equals(account.getClient()))
                .collect(Collectors.toSet());

    }

    public Set<Account> getAccounts() {

        return accountList;

    }

}
