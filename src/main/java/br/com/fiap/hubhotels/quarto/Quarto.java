package br.com.fiap.hubhotels.quarto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

import br.com.fiap.hubhotels.hotel.Hotel;

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
    @NotBlank(message = "O campo tipo não pode estar vazio.")
    private String tipo;

    @Column(name = "DS_QUARTO", nullable = false)
    @NotBlank(message = "O campo descricao não pode estar vazio.")
    private String descricao;

    @Column(name = "QTD_QUARTO", nullable = false)
    @NotBlank(message = "O campo quantidade não pode estar vazio.")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

    @Column(name = "VALOR_DIARIA_QUARTO", nullable = false)
    @NotBlank(message = "O campo valorDiaria não pode estar vazio.")
    private BigDecimal valorDiaria;

    @Column(name = "IMG_QUARTO")
    private String urlImagem;
}