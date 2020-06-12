package ru.otus.lesson2.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.otus.lesson2.domain.Question;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LineDao {
    private CsvMapper mapper;
    private File csvFile;
    private Set<Question> set = new HashSet<>();
    private Queue<Question> questions = new ArrayDeque<>();

    public LineDao(CsvMapper mapper, String strFile) {
        this.mapper = mapper;
        this.csvFile = new File(ClassLoader.getSystemResource(strFile).getFile());

        fillQuestionCache(mapper, csvFile);
    }

    private void fillQuestionCache(CsvMapper mapper, File csvFile) {
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        CsvSchema schema = CsvSchema.builder()
                .addColumn("id", CsvSchema.ColumnType.NUMBER)
                .addColumn("question")
                .addColumn("answer", CsvSchema.ColumnType.ARRAY)
                .build();
        MappingIterator<Question> it = null;
        try {
            it = mapper.readerFor(Question.class).with(schema).readValues(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (it == null) {
            try {
                throw new Exception(csvFile + " отсутствует");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(4);
            }
        }
        while (it.hasNext()) {
            Question row = it.next();
            set.add(row);
        }
        questions.addAll(set);
    }

    public Question getQuestion() {
        Question row = questions.poll();
        if (row == null) {
            questions.addAll(set);
            row = questions.poll();

        }
        return row;
    }

    public int getCount() {
        return set.size();
    }

    public void setSet(ArrayList<Question> set) {
       this.set.addAll(set);
    }

    public void setQuestions(ArrayList<Question> set) {
        this.setSet(set);
        questions.addAll(set);
    }

    public LineDao() {}

}
