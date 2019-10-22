package ru.otus.lesson1.view;

import ru.otus.lesson1.domain.Person;
import ru.otus.lesson1.domain.Question;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class View implements Responsable {

    private Integer count;

    public View(Integer count) {
        this.count = count;
    }

    @Override
    public Person getAnswers(HashSet<Question> set) {
        HashMap<Question, Integer> result = new HashMap<>();
        String inpName = new String("Введите ваше имя".getBytes(), StandardCharsets.UTF_8);
        String inpLastName = new String("Введите вашу фамилию".getBytes(), StandardCharsets.UTF_8);
        System.out.println(inpName);
        Scanner scanner = new Scanner(System.in);
        boolean pass = false;

        String name = scanner.nextLine();
        System.out.println(inpLastName);
        String lastName = scanner.nextLine();
        Person person = new Person(){{
            setName(name);
            setLastName(lastName);
            setResult(result);
        }};

        for (Question question : set) {
            System.out.println(question.getQuestion());
            AtomicInteger j = new AtomicInteger(1);
            question.getAnswer().stream().forEach(a -> {
                System.out.println(j.getAndIncrement() + " " + a);
            });

            Integer numAnsw = null;
            while (numAnsw == null) {
                try {
                    numAnsw = scanner.nextInt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            result.put(question, numAnsw);
        }

        scanner.close();

        return person;
    }
}
