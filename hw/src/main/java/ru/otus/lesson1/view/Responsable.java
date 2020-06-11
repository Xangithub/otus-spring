package ru.otus.lesson1.view;

import ru.otus.lesson1.domain.Person;
import ru.otus.lesson1.domain.Question;
import java.util.HashSet;

public interface Responsable {
    Person getAnswers(HashSet<Question> set);
}
