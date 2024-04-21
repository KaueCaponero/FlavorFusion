package br.com.fiap.hubhotels.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import br.com.fiap.hubhotels.usuario.Usuario;
import br.com.fiap.hubhotels.usuario.UsuarioRepository;

@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent>{

    @Autowired
    UsuarioRepository repository;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        OAuth2User principal = (OAuth2User) event.getAuthentication().getPrincipal();
        String email = principal.getAttribute("email");

        var usuario = repository.findByEmail(email);

        if (usuario.isEmpty()) {
            var novoUsuario = new Usuario(principal);
            repository.save(novoUsuario);
        }
    }
}