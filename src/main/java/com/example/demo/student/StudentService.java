package com.example.demo.student;

import org.springframework.stereotype.Service;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
