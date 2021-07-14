package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;

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

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
