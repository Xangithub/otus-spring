package ru.otus.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.lesson2.domain.Question;
import ru.otus.lesson2.service.QuestionService;

import java.io.IOException;
import java.util.HashSet;

@ComponentScan
public class Main {
    public static boolean lang=true;
    static  final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    static {
        applicationContext.register(Main.class);
        applicationContext.refresh();
    }

    public static void main(String[] args) throws IOException {

        QuestionService questionServ = applicationContext.getBean("questionService", QuestionService.class);

        final HashSet<Question> questions = questionServ.getQuestions();
        questionServ.callProcess(questions);
    }

}
