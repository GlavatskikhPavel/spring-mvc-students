package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.glavatskikh.model.Term;
import ru.glavatskikh.services.DisciplineServices;
import ru.glavatskikh.services.TermServices;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/terms")
public class TermController {
    private final TermServices termServices;
    private final DisciplineServices disciplineServices;

    @GetMapping()
    public String getAll(Model model, @ModelAttribute("term") Term term,
                         @RequestParam(value = "id", required = false) Long id) {
        if (id == null) {
            List<Term> terms = termServices.getAll();
            Term termDb = termServices.findOne(1L);
            model.addAttribute("disciplineList", termServices.getDisciplines(termDb));
            model.addAttribute("termList", terms);
            model.addAttribute("duration", terms.get(0).getDuration());
        } else {
            Term termDb = termServices.findOne(id);
            model.addAttribute("termList", termServices.getAll());
            model.addAttribute("disciplineList", termServices.getDisciplines(termDb));
            model.addAttribute("duration", termDb.getDuration());
            model.addAttribute("idTerm", termDb.getId());
            model.addAttribute("idDelete", termDb.getId());
        }
        return "term/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String getFormNew(@ModelAttribute("term") Term term, Model model) {
        model.addAttribute("disciplineList", disciplineServices.getAll());
        return "term/new";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit")
    public String getEdit(@RequestParam(value = "idModify", required = false) Long id,
                          Model model, @ModelAttribute("term") Term term) {
        if (id == null) {
            return "redirect:/terms";
        }
        Term termDb = termServices.findOne(id);
        model.addAttribute("disciplineList", disciplineServices.getAll());
        model.addAttribute("duration", termDb.getDuration());
        model.addAttribute("idTerm", termDb.getId());
        return "term/edit";
    }

    @PostMapping
    public String save(@ModelAttribute("term") Term term) {
        termServices.save(term);
        return "redirect:/terms";
    }

    @PatchMapping
    public String update(@ModelAttribute("term") Term term,
                         @RequestParam(value = "id", required = false) Long id) {
        termServices.update(id, term);
        return "redirect:/terms";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping
    public String delete(@RequestParam(value = "idDelete", required = false) Long id) {
        if (id == null || id == 1) {
            return "redirect:/terms";
        }
        termServices.delete(id);
        return "redirect:/terms";
    }
}
