package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.glavatskikh.exceptions.DisciplineNotFoundException;
import ru.glavatskikh.model.Discipline;
import ru.glavatskikh.repository.DisciplineRepository;
import ru.glavatskikh.services.DisciplineServices;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DisciplineServicesImpl implements DisciplineServices {
    private final DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> getAll() {
        log.info("Get all Disciplines");
        return disciplineRepository.findAll();
    }

    @Override
    public void save(Discipline discipline) {
        log.info("Save new Disciplines");
        disciplineRepository.save(discipline);
    }

    @Override
    public void delete(String ids) {
        String[] isdArray = ids.split(" ");
        for (String id : isdArray) {
            Discipline discipline = getById(Long.parseLong(id));
            disciplineRepository.delete(discipline);
            log.info("Delete Discipline: {}", discipline.getName());
        }
    }

    @Override
    public void update(Long id, Discipline discipline) {
        Discipline updateDiscipline = new Discipline();
        updateDiscipline.setId(discipline.getId());
        updateDiscipline.setName(discipline.getName());
        log.info("Update Disciplines");
        disciplineRepository.save(updateDiscipline);
    }

    @Override
    public Discipline getById(Long id) {
        Discipline discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new DisciplineNotFoundException("Not found Discipline with id: " + id));
        log.info("Get Student: {}", discipline.getName());
        return discipline;
    }
}
