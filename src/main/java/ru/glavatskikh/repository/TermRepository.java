package ru.glavatskikh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.glavatskikh.model.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
}
