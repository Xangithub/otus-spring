package ru.otus.lesson2.service;

import ru.otus.lesson2.Main;
import ru.otus.lesson2.dao.ReadQuestionDaoCsv;
import ru.otus.lesson2.domain.Person;
import ru.otus.lesson2.domain.Question;
import ru.otus.lesson2.view.Responsable;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;

public class QuestionService {
    private ReadQuestionDaoCsv readQuestionDaoCsv;
    private Responsable responsable;
    private QuestionAnalyzer questionAnalyzer;
    private int count;

    public QuestionService(ReadQuestionDaoCsv readQuestionDaoCsv, Responsable responsable, QuestionAnalyzer questionAnalyzer) {
        this.readQuestionDaoCsv = readQuestionDaoCsv;
        this.responsable = responsable;
        this.questionAnalyzer = questionAnalyzer;
        this.count= readQuestionDaoCsv.getCount();

    }

    public void setCount(Integer count) throws Exception {
        this.count = count;
        if (count > readQuestionDaoCsv.getCount()) throw new Exception("Задайте меньше вопросов, чем в базе");
    }

    /***
     * Здесь загружаются вопросы из DAO согласно count
     * Можно было б отдать ссылку на очередь, но вопросов в базе может быть больше чем нужно для опроса.
     *
     * @param questions*/

    public void callProcess(HashSet<Question> questions){
        boolean pass = false;

        /*** Отдаём вопросы на обработку и получаем ответы тестируемого */
        Person person = responsable.getAnswers(questions);
        String name = person.getName();

        /*** очень простая логика анализа ответов затем меняем на свою */
        final HashMap<Question, Integer> result = person.getResult();

        QuestionAnalyzerInterface analyzerMethod = map -> {
            for (Question question : map.keySet()) {
                if (question.getId()==1 && map.get(question)==2) return true;
            }
            return false;
        };

        final boolean analyzeResult = questionAnalyzer.analyze(result, analyzerMethod);

        String out = Main.lang ? "Test passed, " + name : new String (("Уважаемый(ая), " + name + ", Вы прошли тест").getBytes(),  StandardCharsets.UTF_8 );
        if (pass) System.out.println(out);

        String report = analyzeResult ? out : "Test failed";

        System.out.println(report);

    }
    public HashSet<Question> getQuestions(){
        HashSet<Question> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Question question = readQuestionDaoCsv.getQuestion();
            set.add(question);
        }
        return set;
    }

    public Integer getCount() {
        return count;
    }

}
