package ru.otus.lesson2.view;

import ru.otus.lesson2.domain.Person;
import ru.otus.lesson2.domain.Question;
import java.util.HashSet;

public interface Responsable {
    Person getAnswers(HashSet<Question> set);
}
