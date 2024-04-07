package br.com.fiap.hubhotels.quarto;

import br.com.fiap.hubhotels.hotel.Hotel;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_QUARTO")
    private Long id;

    @Column(name = "TP_QUARTO", nullable = false)
    @NotBlank(message = "{quarto.tipo.notblank}")
    private String tipo;

    @Column(name = "DS_QUARTO", nullable = false)
    @Size(min = 10, max = 255, message = "{quarto.descricao.size}")
    @NotBlank(message = "{quarto.descricao.notblank}")
    private String descricao;

    @Column(name = "QTD_QUARTO", nullable = false)
    @Positive(message = "{quarto.quantidade.positive}")
    @NotBlank(message = "{quarto.quantidade.notblank}")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Column(name = "VALOR_DIARIA_QUARTO", nullable = false)
    @Positive(message = "{quarto.valorDiaria.positive}")
    @NotBlank(message = "{quarto.valorDiaria.notblank}")
    private BigDecimal valorDiaria;

    @Column(name = "IMG_QUARTO")
    private String urlImagem;
}