package ru.glavatskikh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.glavatskikh.model.Grade;
import ru.glavatskikh.model.Student;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> getByStudent(Student student);
}
