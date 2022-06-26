package com.testetitan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoDTO {

    @NotNull
    @NotEmpty
    private String placa;
    @NotNull
    @NotEmpty
    private String modelo;

}
