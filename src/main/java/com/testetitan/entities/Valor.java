package com.testetitan.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Builder
public class Valor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="valor_primeira_hora")
    private float valorPrimeiraHora;
    @Column(name="valor_demais_horas")
    private float valorDemaisHoras;
    @Column(name="data_fim")
    private LocalDateTime dataFinal;



}
