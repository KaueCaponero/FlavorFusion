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
            new Receita(null, "Bolo de Fubá", "março de 2018", "Receita de bolo sem recheio"),
            new Receita(null, "Torta de Palmito", "abril de 2019", "Receita de bolo sem recheio"),
            new Receita(null, "Brigadeiro", "agosto de 2021", "Receita de bolo sem recheio")
        ));
        return "receita/index";
    }
    
    
}
