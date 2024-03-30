package br.com.fiap.hubhotels.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.hubhotels.quarto.QuartoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("hotels")
public class HotelController {

    @Autowired
    HotelRepository repository;

    @Autowired
    QuartoRepository quartoRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("hotels", repository.findAll());
        return "hotel/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {

        var hotel = repository.findById(id);

        if (hotel.isEmpty()) {
            redirect.addFlashAttribute("errorMessage", "Erro ao deletar. Hotel não encontrado.");
            return "redirect:/hotels";
        }

        quartoRepository.deleteByHotelId(id);
        repository.deleteById(id);
        redirect.addFlashAttribute("sucessMessage", "Hotel deletado com sucesso.");
        return "redirect:/hotels";
    }

    @GetMapping("new")
    public String form() {
        return "hotel/form";
    }

    @PostMapping
    public String create(Hotel hotel, RedirectAttributes redirect) {        
        repository.save(hotel);
        redirect.addFlashAttribute("sucessMessage", "Hotel cadastrado com sucesso.");
        return "redirect:/hotels";
    }
}