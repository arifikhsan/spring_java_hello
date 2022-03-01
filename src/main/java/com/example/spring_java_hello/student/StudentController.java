package com.example.spring_java_hello.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> all() {
        return service.all();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        service.create(student);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        service.update(id, name, email);
    }
}
