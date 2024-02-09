package ru.glavatskikh.services;

import ru.glavatskikh.model.Student;

import java.util.List;

public interface StudentServices {
    List<Student> getAll();
    void save(Student student);
    void delete(String ids);
    void update(long id, Student student);
    Student findOne(Long id);
}
