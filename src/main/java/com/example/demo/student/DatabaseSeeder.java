package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final StudentService studentService;

    public DatabaseSeeder(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student();
        student1.setName("Matt");
        student1.setEmail("testing@gmail.com");
        student1.setGender(Gender.MALE);

        Student student2 = new Student();
        student2.setName("Andy");
        student2.setEmail("testing2332@gmail.com");
        student2.setGender(Gender.FEMALE);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
    }
}
