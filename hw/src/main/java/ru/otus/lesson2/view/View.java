package ru.otus.lesson2.view;

import ru.otus.lesson2.Main;
import ru.otus.lesson2.domain.Person;
import ru.otus.lesson2.domain.Question;

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
      String inpName = Main.lang ? "Input your name" : new String("Введите ваше имя".getBytes(), StandardCharsets.UTF_8);
      String inpLastName = Main.lang ? "Input your last name" : new String("Введите вашу фамилию".getBytes(), StandardCharsets.UTF_8);

        System.out.println(inpName);
//        final String property = System.getProperty("line.separator");
//        System.out.println(property);
        Scanner scanner = new Scanner(System.in);
        //.useDelimiter("\n");
        String name = scanner.next();

        System.out.println(inpLastName);
        String lastName = scanner.next();
        //scanner.reset();
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
