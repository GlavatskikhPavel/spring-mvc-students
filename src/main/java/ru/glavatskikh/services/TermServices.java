package ru.glavatskikh.services;

import ru.glavatskikh.model.Discipline;
import ru.glavatskikh.model.Term;

import java.util.List;

public interface TermServices {
    List<Term> getAll();
    void save(Term term);
    void delete(String ids);
    void update(long id, Term term);
    Term findOne(Long id);
    List<Discipline> getDisciplines(Term term);
}
