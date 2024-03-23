package br.com.fiap.flavorfusion.receitaIngrediente;

import java.io.Serializable;

import br.com.fiap.flavorfusion.ingrediente.Ingrediente;
import br.com.fiap.flavorfusion.receita.Receita;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaIngredienteId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_RECEITA")
    private Receita receita;

    @ManyToOne
    @JoinColumn(name = "ID_INGREDIENTE")
    private Ingrediente ingrediente;
}