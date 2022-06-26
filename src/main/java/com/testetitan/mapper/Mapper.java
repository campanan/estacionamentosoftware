package com.testetitan.mapper;

import com.testetitan.entities.Movimento;
import com.testetitan.entities.MovimentoDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Mapper {

    public MovimentoDTO toMovimentoDto(Movimento movimento){
        String placa = movimento.getPlaca();
        String modelo = movimento.getModelo();
        return new MovimentoDTO(placa, modelo);
    }

    public Movimento toMovimento(MovimentoDTO movimentoDTO){
        return new Movimento(movimentoDTO.getPlaca(), movimentoDTO.getModelo(),LocalDateTime.now());
    }


}
