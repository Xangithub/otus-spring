package ru.otus.lesson2.service;

import ru.otus.lesson2.domain.Question;

import java.util.HashMap;

public class QuestionAnalyzer{

    /**
     * Какая то логика анализа теста
     */
    boolean analyze(HashMap<Question, Integer> result, QuestionAnalyzerInterface questionAnalyzerInterface) {
       return questionAnalyzerInterface.analyze(result);
    }
}
