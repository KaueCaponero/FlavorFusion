package br.com.fiap.flavorfusion.receita;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA")
    @SequenceGenerator(name = "SQ_RECEITA", sequenceName = "SQ_RECEITA", allocationSize = 1)
    @Column(name = "ID_RECEITA")
    private Long id;

    @Column(name = "NM_RECEITA", nullable = false)
    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @Column(name = "IMG_RECEITA")
    private String urlImagem;

    @Column(name = "DT_RECEITA", nullable = false)
    @NotBlank(message = "O campo data não pode estar vazio.")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "DS_RECEITA", nullable = false)
    @NotBlank(message = "O campo descrição não pode estar vazio.")
    private String descricao;

    // Construtor Personalizado
    public Receita(Long id, String nome, String urlImagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.data = new Date();
        this.descricao = descricao;
    }
}