package ru.glavatskikh.services;

import ru.glavatskikh.model.Discipline;

import java.util.List;

public interface DisciplineServices {
    List<Discipline> getAll();
    void save(Discipline discipline);
    void delete(String ids);
    void update(Long id, Discipline discipline);
    Discipline getById(Long id);
}
