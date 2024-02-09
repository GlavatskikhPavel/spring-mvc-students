package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.glavatskikh.model.Group;
import ru.glavatskikh.model.Student;
import ru.glavatskikh.repository.GroupRepository;
import ru.glavatskikh.repository.StudentRepository;
import ru.glavatskikh.services.StudentServices;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServicesImpl implements StudentServices {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<Student> getAll() {
        log.info("Get all Students");
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        try {
            Group groupDb = getGroup(student.getGroup().getName());
            if (groupDb == null) {
                Group group = new Group();
                group.addStudent(student);
                group.setName(student.getGroup().getName());
                student.setGroup(group);
                groupRepository.save(group);
                studentRepository.save(student);
                log.info("Save new group: {}", group.getName());
                log.info("Save new student: {}", student.getName());
            } else {
                student.setGroup(groupDb);
                groupDb.addStudent(student);
                studentRepository.save(student);
                log.info("Save new student by existing group: {}", groupDb.getName());
            }
        } catch (NullPointerException exception) {
            throw exception;
        }
    }

    public void update(long id, Student student) {
        Student updateStudent = new Student();
        updateStudent.setId(student.getId());
        updateStudent.setSurname(student.getSurname());
        updateStudent.setName(student.getName());
        Group groupDb = getGroup(student.getGroup().getName());
        if (groupDb == null) {
            Group group = new Group();
            group.addStudent(updateStudent);
            group.setName(student.getGroup().getName());
            groupRepository.save(group);
            updateStudent.setGroup(group);
        } else {
            updateStudent.setGroup(groupDb);
            groupDb.addStudent(student);
        }
        groupRepository.save(updateStudent.getGroup());
        updateStudent.setAdmissionDate(student.getAdmissionDate());
        studentRepository.save(updateStudent);
    }

    public void delete(String ids) {
        String[] isdArray = ids.split(" ");
        for (String id : isdArray) {
            Student student = findOne(Long.parseLong(id));
            studentRepository.delete(student);
            log.info("Delete Student: {}", student.getName());
        }
    }

    private Group getGroup(String name) throws NullPointerException {
        Group groupDb = groupRepository.findGroupByName(name);
        if (groupDb == null) {
            log.info("There is no such group in the database");
        } else {
            log.info("Get group by name: {}", groupDb.getName());
        }
        return groupDb;
    }

    public Student findOne(Long id) {
        Optional<Student> foundStudent =studentRepository.findById(id);
        return foundStudent.orElse(null);
    }
}
