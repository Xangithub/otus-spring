package ru.otus.lesson1.service;

import ru.otus.lesson1.domain.Question;

import java.util.HashMap;

@FunctionalInterface
public interface QuestionAnalyzerInterface {
    boolean analyze(HashMap<Question, Integer> result);
    /*
    default boolean analyze(HashMap<Question, Integer> result){
        for (Question question : result.keySet()) {
            if (question.getId() == 3) return true;
        }
        return false;
    }*/
}
