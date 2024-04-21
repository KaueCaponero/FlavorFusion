package br.com.fiap.hubhotels.usuario;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "HubUsuario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends DefaultOAuth2User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String avatarUrl;

    public Usuario() {
        super(
            List.of(new SimpleGrantedAuthority("ROLE_USER")),
            Map.of("name", "Anonymous"),
            "name"
        );
    }

    public Usuario(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes,
            String nameAttributeKey) {
        super(authorities, attributes, nameAttributeKey);
    }

    public Usuario(OAuth2User principal) {
        super(principal.getAuthorities(), principal.getAttributes(), "name");
        this.name = principal.getAttribute("name");
        this.email = principal.getAttribute("email");
        
        String avatarUrl = null;
        if (principal.getAttribute("avatar_url") != null) {
            avatarUrl = principal.getAttribute("avatar_url");
        }
        else if (principal.getAttribute("picture") != null) {
            avatarUrl = principal.getAttribute("picture");
        }

        this.avatarUrl = avatarUrl;
    }
}