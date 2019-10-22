package ru.otus.lesson1;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("config.xml");
//        PersonService personService = xmlApplicationContext.getBean(PersonService.class);
//        personService.printPersons();
        CsvMapper mapper = xmlApplicationContext.getBean("mapper", CsvMapper.class);
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        File csvFile = new File("C:\\Otus\\lesson1\\hw1\\src\\main\\resources\\q.csv"); // or from String, URL etc
        MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(csvFile);
        while (it.hasNext()) {
            String[] row = it.next();
            // and voila, column values in an array. Works with Lists as well
            System.out.println(Arrays.asList(row));
        }
    }
}
