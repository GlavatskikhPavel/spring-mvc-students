package ru.glavatskikh.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@Table(name = "grade")
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "term_id", referencedColumnName = "id")
    private Term term;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    private Discipline discipline;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    private int grade;
}
