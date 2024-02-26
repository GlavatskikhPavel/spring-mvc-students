package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.glavatskikh.model.Grade;
import ru.glavatskikh.model.Student;
import ru.glavatskikh.repository.GradeRepository;
import ru.glavatskikh.services.GradeServices;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeServicesImpl implements GradeServices {
    private final GradeRepository gradeRepository;

    @Override
    public List<Grade> getAll(Student student) {
        log.info("Get all Grade");
        return gradeRepository.getByStudent(student);
    }
}
