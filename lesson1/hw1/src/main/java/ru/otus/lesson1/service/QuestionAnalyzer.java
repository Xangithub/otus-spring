package ru.otus.lesson1.service;

import ru.otus.lesson1.domain.Question;

import java.util.HashMap;

public class QuestionAnalyzer implements QuestionAnalyzerInterface{

    /**
     * Какая то логика анализа теста
     */
    @Override
    boolean analyze(HashMap<Question, Integer> result, QuestionAnalyzerInterface questionAnalyzerInterface) {
       return questionAnalyzerInterface.analyze(result);
    }
}
