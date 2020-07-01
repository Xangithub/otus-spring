package ru.otus.lesson2.config;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.lesson2.dao.ReadQuestionDaoCsv;
import ru.otus.lesson2.service.QuestionAnalyzer;
import ru.otus.lesson2.service.QuestionService;
import ru.otus.lesson2.view.Responsable;
import ru.otus.lesson2.view.View;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean
    ReadQuestionDaoCsv lineDao(@Value("${file}") String file){
        CsvMapper csvMapper = new CsvMapper();
        return new ReadQuestionDaoCsv(csvMapper,file);
    }

    @Bean
    QuestionAnalyzer questionAnalyzer(){
        return new QuestionAnalyzer();
    }

    @Bean
    Responsable responsable(@Value("${count}") int count){
        return new View(count);
    }

   @Bean
   QuestionService  questionService(ReadQuestionDaoCsv readQuestionDaoCsv, Responsable resp, QuestionAnalyzer questionAnalyzer){
       return new QuestionService(readQuestionDaoCsv,resp,questionAnalyzer);
   }

}
