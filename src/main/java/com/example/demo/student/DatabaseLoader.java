package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final StudentService studentService;

    public DatabaseLoader(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student();
        student1.setId(234L);
        student1.setName("Matt");
        student1.setEmail("testing@gmail.com");
        student1.setGender("MALE");

        Student student2 = new Student();
        student2.setId(23434634L);
        student2.setName("Andy");
        student2.setEmail("testing2332@gmail.com");
        student2.setGender("FEMALE");

        studentService.createStudent(student1);
        studentService.createStudent(student2);
    }
}
