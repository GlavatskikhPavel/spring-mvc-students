package ru.glavatskikh.services;

import ru.glavatskikh.model.Grade;
import ru.glavatskikh.model.Student;

import java.util.List;

public interface GradeServices {
    List<Grade> getAll(Student student);
}
