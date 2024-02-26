package ru.glavatskikh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "discipline")
@ToString
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotEmpty(message = "Наименование дисциплины не должно быть пустым")
    @Size(min = 2, max = 30, message = "От 2 до 30 символов длиной")
    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();

    @ManyToMany(mappedBy = "disciplines")
    private List<Term> terms = new ArrayList<>();
}
