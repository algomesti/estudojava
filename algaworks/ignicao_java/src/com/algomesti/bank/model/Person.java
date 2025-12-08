package com.algomesti.bank.model;

import java.time.LocalDateTime;

public class Person {

    private final String document;
    private final String name;
    private PersonType personType = PersonType.INDIVIDUAL;
    private LocalDateTime lastUpdate = LocalDateTime.now();

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Person(String document, String name) {
        this.document = document;
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
