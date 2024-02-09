package ru.glavatskikh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.glavatskikh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
