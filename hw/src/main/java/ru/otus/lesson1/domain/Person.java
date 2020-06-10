package ru.otus.lesson1.domain;

import java.util.HashMap;

public class Person {
    private String name;
    private String lastName;
    private HashMap<Question,Integer> result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap<Question, Integer> getResult() {
        return result;
    }

    public void setResult(HashMap<Question, Integer> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {

    }
}
