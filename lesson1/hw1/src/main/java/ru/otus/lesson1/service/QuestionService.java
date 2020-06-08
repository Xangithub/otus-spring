package ru.otus.lesson1.service;

import ru.otus.lesson1.Main;
import ru.otus.lesson1.dao.LineDao;
import ru.otus.lesson1.domain.Person;
import ru.otus.lesson1.domain.Question;
import ru.otus.lesson1.view.Responsable;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;

public class QuestionService {
    private LineDao lineDao;
    private Responsable responsable;
    private QuestionAnalyzer questionAnalyzer;

    private Integer count;

    public QuestionService(LineDao lineDao, Responsable responsable, QuestionAnalyzer questionAnalyzer) {
        this.lineDao = lineDao;
        this.responsable = responsable;
        this.questionAnalyzer = questionAnalyzer;
    }

    public void setCount(Integer count) throws Exception {
        this.count = count;
        if (count > lineDao.getCount()) throw new Exception("Задайте меньше вопросов, чем в базе");
    }

    /***
     * Здесь загружаются вопросы из DAO согласно count
     * Можно было б отдать ссылку на очередь, но вопросов в базе может быть больше чем нужно для опроса.
     *
     * @param questions*/

    public void callProcess(HashSet<Question> questions){
        boolean pass = false;

        /*** Отдаём вопросы на обработку и получаем ответ */
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

        questionAnalyzer.analyze(result, analyzerMethod);

        String out = Main.lang ? "Test passed, " + name : new String (("Уважаемый(ая), " + name + ", Вы прошли тест").getBytes(),  StandardCharsets.UTF_8 );
        if (pass) System.out.println(out);

    }
    public HashSet<Question> getQuestions(){
        HashSet<Question> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Question question = lineDao.getQuestion();
            set.add(question);
        }
        return set;
    }

    public Integer getCount() {
        return count;
    }

}
