package ru.otus.lesson1.service;

import ru.otus.lesson1.dao.LineDao;

public class QuestionServ {
    LineDao lineDao;

    public QuestionServ(LineDao lineDao) {
        this.lineDao = lineDao;
    }

}
