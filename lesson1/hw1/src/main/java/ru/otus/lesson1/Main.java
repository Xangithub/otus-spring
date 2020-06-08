package ru.otus.lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.lesson1.domain.Question;
import ru.otus.lesson1.service.QuestionService;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static boolean lang=true;

    static final ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("config.xml");

    public static void main(String[] args) {

        QuestionService questionServ = xmlApplicationContext.getBean("questionService", QuestionService.class);


        final HashSet<Question> questions = questionServ.getQuestions();
        questionServ.callProcess(questions);

    }
}
