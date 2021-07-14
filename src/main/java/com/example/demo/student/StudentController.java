package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudents() ;
    }

    @PostMapping(
       value = "/addStudent",
       consumes = "application/json",
       produces = "application/json"
    )
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
