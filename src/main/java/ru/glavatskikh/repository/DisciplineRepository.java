package ru.glavatskikh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.glavatskikh.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
