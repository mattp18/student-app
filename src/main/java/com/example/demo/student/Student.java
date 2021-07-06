package com.example.demo.student;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue()
    private Long id;

    private String name;
    private String email;
    private String gender;


}
