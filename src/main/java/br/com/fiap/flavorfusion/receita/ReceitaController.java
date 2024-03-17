package br.com.fiap.flavorfusion.receita;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("receitas")
public class ReceitaController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("receitas", List.of(
            "Receita 1",
            "Receita 2",
            "Receita 3",
            "Teste Unitário"
        ));
        return "receita/index";
    }
    
    
}
