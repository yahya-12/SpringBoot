package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

     @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student y = new Student(
                    2l,
                    "Yahya",
                    LocalDate.of(2001,2,16),
                    "yahyabahaj@gmail.com"

            );
            Student x = new Student(
                    3l,
                    "Yasser",
                    LocalDate.of(2009,4,23),
                    "yasserbahaj@gmail.com"

            );

            repository.saveAll(List.of(y,x));
        };

    }
}
