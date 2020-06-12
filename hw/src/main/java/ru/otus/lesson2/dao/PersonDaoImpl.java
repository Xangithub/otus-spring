package ru.otus.lesson2.dao;

import ru.otus.lesson2.domain.Person;

public class PersonDaoImpl implements PersonDaoI {
    @Override
    public Person getPeson() {
        return new Person("Peter", "Ivanov");
    }
}
