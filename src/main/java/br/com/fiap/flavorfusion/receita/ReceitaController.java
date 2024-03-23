package br.com.fiap.flavorfusion.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("receitas")
public class ReceitaController {

    @Autowired
    ReceitaRepository repository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("receitas", repository.findAll());
        return "receita/index";
    }
}