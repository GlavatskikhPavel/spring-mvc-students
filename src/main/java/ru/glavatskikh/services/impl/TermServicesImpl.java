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
        log.info("Get all Term");
        return termRepository.findAll();
    }

    @Override
    public void save(Term term) {
        term.setName("Семестр " + (Integer.parseInt(getLastId()) + 1));
        log.info("Save Term", term.getName());
        termRepository.save(term);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Term");
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
        log.info("Update Term", newTerm.getName());
        termRepository.save(newTerm);
    }

    @Override
    public Term findOne(Long id) {
        Optional<Term> foundTerm = termRepository.findById(id);
        log.info("Term found", foundTerm);
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
