package com.testetitan.utils;

import com.testetitan.entities.Movimento;
import com.testetitan.entities.Valor;
import com.testetitan.exceptions.ResourceNotFoundException;
import com.testetitan.repositories.MovimentoRepository;
import com.testetitan.repositories.ValorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Utils {

    public Valor findValorOrThrowNotFound (Integer id, ValorRepository valorRepository){
        return valorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Valor not found."));
    }

//    public Movimento findMovimentoOrThrowNotFound(String placa, MovimentoRepository movimentoRepository){
//
//       return movimentoRepository.findByPlaca(placa).orElseThrow(() -> new ResourceNotFoundException("Movimento"));

}
