package com.example.demo.student;

import lombok.*;

import javax.persistence.*;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
