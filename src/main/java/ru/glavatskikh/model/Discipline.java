package ru.glavatskikh.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "discipline")
@ToString(exclude = {"grade"})
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "discipline")
    private Grade grade;

    @ManyToMany(mappedBy = "disciplines")
    private List<Term> terms = new ArrayList<>();
}
