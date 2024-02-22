package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.glavatskikh.model.Grade;
import ru.glavatskikh.model.Student;
import ru.glavatskikh.model.Term;
import ru.glavatskikh.services.DisciplineServices;
import ru.glavatskikh.services.GradeServices;
import ru.glavatskikh.services.StudentServices;
import ru.glavatskikh.services.TermServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/students")
@Controller
@RequiredArgsConstructor
public class StudentControllers {
    private final StudentServices studentServices;
    private final GradeServices gradeServices;
    private final DisciplineServices disciplineServices;
    private final TermServices termServices;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("students", studentServices.getAll());
        return "student/list";
    }

    @GetMapping("/new")
    public String getFormNew(@ModelAttribute("student") Student student) {
        return "student/new";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam("idModify") Long id, Model model) {
        model.addAttribute("student", studentServices.findOne(id));
        return "student/edit";
    }

    @PostMapping()
    public String save(@ModelAttribute("student") Student student) {
        studentServices.save(student);
        return "redirect:/students";
    }

    @PatchMapping
    public String update(@ModelAttribute("student") Student student,
                         @RequestParam("id") Long id) {
        studentServices.update(id, student);
        return "redirect:/students";
    }

    @DeleteMapping()
    public String delete(@RequestParam("idsDelete") String idsDelete) {
        studentServices.delete(idsDelete);
        return "redirect:/students";
    }

    @GetMapping("/progress")
    public String progress(@RequestParam(value = "id_progress", required = false) Long idStudent,
                           @RequestParam(value = "id", required = false) Long idTerm,
                           @ModelAttribute("student") Student student, Model model,
                           @ModelAttribute("term") Term term) {
        if (idTerm != null) {
            Student studentDB = studentServices.findOne(idStudent);
            model.addAttribute("student", studentDB);
            List<Grade> grades = studentDB.getGrades();
            System.out.println();
            List<Grade> gradesTermId = grades
                    .stream()
                    .filter(n -> n.getTerm().getId().equals(idTerm))
                    .collect(Collectors.toList());
            model.addAttribute("grades", gradesTermId);
            model.addAttribute("termList", termServices.getAll());
        } else {
            Student studentDB = studentServices.findOne(idStudent);
            model.addAttribute("student", studentDB);
            List<Grade> grades = studentDB.getGrades();
            model.addAttribute("termList", termServices.getAll());
            model.addAttribute("grades", grades);
        }
        return "student/progress";
    }
}
