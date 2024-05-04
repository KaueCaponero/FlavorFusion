package br.com.fiap.hubhotels.usuario;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.hubhotels.hotel.HotelRepository;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;
 
    @GetMapping
    public String index(Model model, @AuthenticationPrincipal DefaultOAuth2User user) {
        Usuario myUser = (Usuario) user;
        model.addAttribute("user", user.getAttribute("name"));
        model.addAttribute("avatar", user.getAttribute("avatar_url"));
        model.addAttribute("principal", myUser);

        List<Object[]> counts = hotelRepository.countHotelsPerUser();
        Map<Long, Integer> hotelCounts = new HashMap<>();
        for (Object[] count : counts) {
            Long userId = (Long) count[0];
            Integer countValue = ((Number) count[1]).intValue();
            hotelCounts.put(userId, countValue);
        }

        List<Usuario> usuarios = userRepository.findAll();

        usuarios.sort(Comparator.comparingInt(usuario -> hotelCounts.getOrDefault(((Usuario) usuario).getId(), 0)).reversed());

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("hotelCounts", hotelCounts);

        return "usuario/index";
    }
}