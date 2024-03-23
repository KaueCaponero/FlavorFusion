package br.com.fiap.flavorfusion.ingrediente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INGREDIENTE")
    @SequenceGenerator(name = "SQ_INGREDIENTE", sequenceName = "SQ_INGREDIENTE", allocationSize = 1)
    @Column(name = "ID_INGREDIENTE")
    private Long id;

    @Column(name = "NM_INGREDIENTE", nullable = false)
    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @Column(name = "UND_MED_INGREDIENTE", nullable = false)
    private String undMedida;
}