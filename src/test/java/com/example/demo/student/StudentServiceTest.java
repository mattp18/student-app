package com.example.demo.student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

//    @Captor
//    ArgumentCaptor<Student> studentCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStudent() {
//        Student student = new Student();
//        student.setId(1L);
//        student.setEmail("test@test.com");
//        student.setName("Bill");
//
//        Student student1 = studentService.createStudent(student);
//
//        Mockito.verify(studentRepository).save(studentCaptor.capture());
//
//        Student value = studentCaptor.getValue();
//
//        assertEquals(student, value);
    }

    @Test
    void findAllStudents() {
        Student student = new Student();
        student.setId(1L);
        student.setEmail("test@test.com");
        student.setName("Bill");

        List<Student> expectedStudents = Collections.singletonList(student);
        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudents);
        Iterable<Student> actualStudents = studentService.findAllStudents();

        assertEquals(actualStudents, expectedStudents);

    }
}