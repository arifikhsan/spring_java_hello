package com.example.spring_java_hello.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> all() {
        return repository.findAll();
    }

    public void create(Student student) {
        Optional<Student> studentOption = repository.findByEmail(student.getEmail());
        if (studentOption.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        repository.save(student);
    }

    public void delete(Long id) {
        boolean isExists = repository.existsById(id);
        if (!isExists) {
            throw new IllegalStateException("Student with id " + id + "does not exists");
        }
        repository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + "does not exists."));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> optionalStudent = repository.findByEmail(email);
            if (optionalStudent.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}
