package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.glavatskikh.model.Discipline;
import ru.glavatskikh.model.Grade;
import ru.glavatskikh.model.Student;
import ru.glavatskikh.model.Term;
import ru.glavatskikh.services.StudentServices;
import ru.glavatskikh.services.TermServices;
import ru.glavatskikh.validator.StudentValidator;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/students")
@Controller
@RequiredArgsConstructor
public class StudentControllers {
    private final StudentServices studentServices;
    private final TermServices termServices;
    private final StudentValidator studentValidator;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("students", studentServices.getAll());
        return "student/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String getFormNew(@ModelAttribute("student") Student student) {
        return "student/new";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit")
    public String getEdit(@RequestParam("idModify") Long id, Model model) {
        model.addAttribute("student", studentServices.findOne(id));
        return "student/edit";
    }

    @PostMapping()
    public String save(@ModelAttribute("student") @Valid Student student,
                       BindingResult bindingResult) {
        studentValidator.validate(student, bindingResult);
        if (bindingResult.hasErrors()) return "student/new";
        studentServices.save(student);
        return "redirect:/students";
    }

    @PatchMapping
    public String update(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult,
                         @RequestParam("id") Long id) {
        studentValidator.validate(student, bindingResult);
        if (bindingResult.hasErrors()) return "student/edit";
        studentServices.update(id, student);
        return "redirect:/students";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping()
    public String delete(@RequestParam("idsDelete") String idsDelete) {
        studentServices.delete(idsDelete);
        return "redirect:/students";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/progress")
    public String progress(@RequestParam(value = "id_progress", required = false) Long idStudent,
                           @RequestParam(value = "id", required = false) Long idTerm,
                           @ModelAttribute("student") Student student, Model model,
                           @ModelAttribute("term") Term term) {
        if (idTerm != null) {
            Student studentDB = studentServices.findOne(idStudent);
            model.addAttribute("student", studentDB);
            List<Grade> gradesTermId = studentDB
                    .getGrades().stream().filter(n -> n.getTerm().getId().equals(idTerm))
                    .collect(Collectors.toList());
            model.addAttribute("grades", gradesTermId);
            model.addAttribute("termList", termServices.getAll());
            model.addAttribute("summa", gradesTermId
                    .stream().mapToInt(Grade::getGrade).sum() * 1.0 /
                    gradesTermId.stream().map(Grade::getDiscipline).toList().size());
        } else {
            Student studentDB = studentServices.findOne(idStudent);
            model.addAttribute("student", studentDB);
            List<Grade> gradesTermId = studentDB.getGrades().stream()
                    .filter(n -> n.getTerm().getId() == 1)
                    .collect(Collectors.toList());
            model.addAttribute("termList", termServices.getAll());
            model.addAttribute("grades", gradesTermId);
            model.addAttribute("summa", gradesTermId
                    .stream().mapToInt(Grade::getGrade).sum() * 1.0 / 5.0);
        }
        return "student/progress";
    }
}
