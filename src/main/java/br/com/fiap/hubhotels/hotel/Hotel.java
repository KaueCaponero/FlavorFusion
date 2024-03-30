package br.com.fiap.hubhotels.hotel;

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
    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @Column(name = "END_HOTEL", nullable = false)
    @NotBlank(message = "O campo endereço não pode estar vazio.")
    private String endereco;

    @Column(name = "IMG_HOTEL")
    private String urlImagem;
}