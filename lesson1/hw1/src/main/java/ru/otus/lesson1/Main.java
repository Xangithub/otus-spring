package ru.otus.lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.lesson1.service.QuestionService;

public class Main {

    static final ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("config.xml");

    public static void main(String[] args) {

        QuestionService questionServ = xmlApplicationContext.getBean("questionService", QuestionService.class);
        questionServ.callProcess();

    }
}
