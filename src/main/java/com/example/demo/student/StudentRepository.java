package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
