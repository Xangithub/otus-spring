package ru.otus.lesson1.domain;

import java.util.Set;

public class Question {
    Integer id;
    String question;
    Set<String> answer;

    public Question(Integer id, String question, Set<String> answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<String> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<String> answer) {
        this.answer = answer;
    }
}
