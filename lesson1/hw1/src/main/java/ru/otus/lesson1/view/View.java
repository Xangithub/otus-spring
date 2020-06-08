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

        boolean pass = false;
        String inpName = "Input your name";
        String inpLastName = "Input your last name";
        System.out.println(inpName);
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name = scanner.next();

        String lastName = null;
        System.out.println(inpLastName);
//        if (scanner.hasNext())
            lastName = scanner.next();
scanner.reset();
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
//                if (scanner.hasNextInt())
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
