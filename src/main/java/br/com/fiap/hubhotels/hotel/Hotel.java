package br.com.fiap.hubhotels.hotel;

import br.com.fiap.hubhotels.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOTEL")
    private Long id;

    @Column(name = "NM_HOTEL", nullable = false)
    @Size(min = 1, max = 255, message = "{hotel.nome.size}")
    @NotBlank(message = "{hotel.nome.notblank}")
    private String nome;

    @Column(name = "END_HOTEL", nullable = false)
    @Size(min = 10, max = 255, message = "{hotel.endereco.size}")
    @NotBlank(message = "{hotel.endereco.notblank}")
    private String endereco;

    @Column(name = "IMG_HOTEL")
    private String urlImagem;

    @ManyToOne
    private Usuario usuario;
}