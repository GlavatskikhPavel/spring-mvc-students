package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.glavatskikh.model.Discipline;
import ru.glavatskikh.model.Term;
import ru.glavatskikh.repository.TermRepository;
import ru.glavatskikh.services.TermServices;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TermServicesImpl implements TermServices {
    private final TermRepository termRepository;

    @Override
    public List<Term> getAll() {
        return termRepository.findAll();
    }

    @Override
    public void save(Term term) {
        term.setName("Семестр " + (Integer.parseInt(getLastId()) + 1));
        termRepository.save(term);
    }

    @Override
    public void delete(Long id) {
        termRepository.delete(findOne(id));
    }

    @Override
    public void update(long id, Term term) {
        Term termDB = findOne(id);
        Term newTerm = new Term();
        newTerm.setId(id);
        newTerm.setName(termDB.getName());
        newTerm.setDisciplines(term.getDisciplines());
        newTerm.setDuration(term.getDuration());
        newTerm.setGrades(termDB.getGrades());
        termRepository.save(newTerm);
    }

    @Override
    public Term findOne(Long id) {
        Optional<Term> foundTerm = termRepository.findById(id);
        return foundTerm.orElse(null);
    }

    public List<Discipline> getDisciplines(Term term) {
        return term.getDisciplines();
    }

    private String getLastId() {
        List<Term> list = termRepository.findAll();
        Term lastElement = list.get(list.size() - 1);
        String line = lastElement.getName();
        String[] array = line.split(" ");
        return array[1];
    }
}
