package ru.otus.lesson1.dao;

import ru.otus.lesson1.domain.Person;

public class PersonDaoImpl implements PersonDaoI {
    @Override
    public Person getPeson() {
        return new Person("Peter", 18);
    }
}
