package br.com.fiap.flavorfusion.receitaIngrediente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaIngrediente {

    @EmbeddedId
    @Column(name = "ID_REC_ING", nullable = false)
    private ReceitaIngredienteId id;

    @Column(name = "QTD_REC_ING", nullable = false)
    @NotNull(message = "O campo quantidade não pode estar vazio.")
    @Positive
    private double quantidade;
}