package ru.otus.lesson1.service;

import ru.otus.lesson1.domain.Question;

import java.util.HashMap;

public class QuestionAnalyzer{

    /**
     * Какая то логика анализа теста
     */
    boolean analyze(HashMap<Question, Integer> result, QuestionAnalyzerInterface questionAnalyzerInterface) {
       return questionAnalyzerInterface.analyze(result);
    }
}
