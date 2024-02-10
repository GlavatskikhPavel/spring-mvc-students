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

    }

    @Override
    public void delete(String ids) {

    }

    @Override
    public void update(long id, Term term) {

    }

    @Override
    public Term findOne(Long id) {
        Optional<Term> foundTerm = termRepository.findById(id);
        return foundTerm.orElse(null);
    }

    public List<Discipline> getDisciplines(Term term) {
        return term.getDisciplines();
    }
}
