package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.glavatskikh.model.Student;
import ru.glavatskikh.services.StudentServices;

@RequestMapping("/students")
@Controller
@RequiredArgsConstructor
public class StudentControllers {
    private final StudentServices studentServices;

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

    @PatchMapping("/progress")
    public String progress(@RequestParam("idProgress") Long id, Model model,
                           @ModelAttribute("student") Student student) {
        model.addAttribute("student", studentServices.findOne(id));



        return "student/progress";
    }
}
