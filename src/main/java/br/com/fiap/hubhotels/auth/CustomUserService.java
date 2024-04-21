package br.com.fiap.hubhotels.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import br.com.fiap.hubhotels.usuario.UsuarioRepository;

@Service
public class CustomUserService extends DefaultOAuth2UserService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");
        var usuario = repository.findByEmail(email);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        return oAuth2User;
    }
    
}