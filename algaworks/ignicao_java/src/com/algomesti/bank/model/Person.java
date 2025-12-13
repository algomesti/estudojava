package com.algomesti.bank.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Person{" +
                "document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", personType=" + personType +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        return ((Person) obj).getDocument().equals(this.getDocument());

    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}
