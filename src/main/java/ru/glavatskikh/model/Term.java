package ru.glavatskikh.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "term")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @ManyToMany
    @JoinTable(
            name = "term_discipline",
            joinColumns = @JoinColumn(name = "term_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id", referencedColumnName="id"))
    private List<Discipline> disciplines = new ArrayList<>();

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Grade> grades = new ArrayList<>();

    @Override
    public String toString() {
        return "Term{" +
                "name='" + name + '\'' +
                '}';
    }
}
