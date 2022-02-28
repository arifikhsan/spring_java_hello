package com.example.spring_java_hello.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> all() {
        return List.of(
                new Student(1L, "Mariam", "mariam@gmail.com", 22, LocalDate.of(2000, 5, 12))
        );
    }
}
