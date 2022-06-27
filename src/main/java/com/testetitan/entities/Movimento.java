package com.testetitan.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Builder
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    private String placa;

    @NotNull
    @NotEmpty
    private String modelo;

    @Column(name="data_entrada")
    private LocalDateTime horarioEntrada;

    @Column(name="data_saida")
    private LocalDateTime horarioSaida;

    @Column(name="tempo")
    private LocalTime tempoTotal;

    @Column(name="valor_pago", columnDefinition = "float default 0.0")
    private float valor;

    public Movimento(String placa, String modelo, LocalDateTime horarioEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.horarioEntrada = horarioEntrada;
    }
}
