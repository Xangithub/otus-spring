package ru.otus.lesson1.service;

import ru.otus.lesson1.dao.PersonDaoI;

public class PersonService {
    PersonDaoI personDao;

    public PersonService(PersonDaoI personDao) {
        this.personDao = personDao;
    }

    public void printPersons(){
        System.out.println(personDao.getPeson());
    }
}
