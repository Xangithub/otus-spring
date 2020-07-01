package ru.otus.lesson2.view;

import ru.otus.lesson2.Main;
import ru.otus.lesson2.domain.Person;
import ru.otus.lesson2.domain.Question;

import java.nio.charset.Charset;
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

        boolean pass = false;
        Charset currentCharset = Charset.defaultCharset();
        String inpName = Main.lang ? "Input your name" : "Введите ваше имя";
//        String inpName = Main.lang ? "Input your name" : new String("Введите ваше имя".getBytes(), StandardCharsets.UTF_8);
        String inpLastName = Main.lang ? "Input your last name" : "Введите вашу фамилию";
//        String inpLastName = Main.lang ? "Input your last name" : new String("Введите вашу фамилию".getBytes(), StandardCharsets.UTF_8);

        System.out.println(currentCharset);

        System.out.println(inpName);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println(inpLastName);

        String lastName = scanner.next();
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setResult(result);
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
