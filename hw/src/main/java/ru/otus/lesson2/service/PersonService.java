package ru.otus.lesson2.service;

import ru.otus.lesson2.dao.PersonDaoI;

public class PersonService {
    PersonDaoI personDao;

    public PersonService(PersonDaoI personDao) {
        this.personDao = personDao;
    }

    public void printPersons(){
        System.out.println(personDao.getPeson());
    }
}
