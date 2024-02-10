package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.glavatskikh.model.Discipline;
import ru.glavatskikh.services.DisciplineServices;

@Controller
@RequiredArgsConstructor
@RequestMapping("/disciplines")
public class DisciplineController {
    private final DisciplineServices disciplineServices;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("disciplines", disciplineServices.getAll());
        return "discipline/list";
    }

    @GetMapping("/new")
    public String getFormNew(@ModelAttribute("discipline") Discipline discipline) {
        return "discipline/new";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam("idModify") String idModify, Model model) {
        model.addAttribute("discipline", disciplineServices.getById(Long.parseLong(idModify)));
        return "discipline/edit";
    }

    @PostMapping
    public String save(@ModelAttribute("discipline") Discipline discipline) {
        disciplineServices.save(discipline);
        return "redirect:/disciplines";
    }

    @PatchMapping
    public String update(@ModelAttribute("discipline") Discipline discipline, @RequestParam("id") Long id) {
        disciplineServices.update(id, discipline);
        return "redirect:/disciplines";
    }

    @DeleteMapping()
    public String delete(@RequestParam("idsDelete") String idsDelete) {
        disciplineServices.delete(idsDelete);
        return "redirect:/disciplines";
    }
}
