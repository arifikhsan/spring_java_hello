package com.example.spring_java_hello.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", "mariam@gmail.com", 22, LocalDate.of(2000, JANUARY, 5));
            Student alex = new Student("Alex", "alex@gmail.com", 21, LocalDate.of(2000, MAY, 20));
            repository.saveAll(List.of(mariam, alex));
        };
    }
}