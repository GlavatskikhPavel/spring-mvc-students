package ru.glavatskikh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            model.addAttribute("termList", terms);
            model.addAttribute("disciplineList" , disciplineServices.getAll());
            model.addAttribute("duration", terms.get(0).getDuration());
        } else {
            Term termDb = termServices.findOne(id);
            model.addAttribute("termList", termServices.getAll());
            model.addAttribute("disciplineList", termServices.getDisciplines(termDb));
            model.addAttribute("duration", termDb.getDuration());
        }
        return "term/list";
    }

    @GetMapping("/new")
    public String getFormNew(@ModelAttribute("term") Term term) {
        return "term/new";
    }
}
