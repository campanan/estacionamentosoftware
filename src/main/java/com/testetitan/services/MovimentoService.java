package com.testetitan.services;

import com.testetitan.entities.Movimento;
import com.testetitan.repositories.MovimentoRepository;
import com.testetitan.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentoService {

    @Autowired
    private final MovimentoRepository movimentoRepository;

    private Utils utils;

    public List<Movimento> listAll() {
        return movimentoRepository.findAll();
    }

    public Movimento insertMovimento(Movimento movimento){
        return movimentoRepository.save(movimento);
    }

    public Movimento findByPlaca(String placa){

        return movimentoRepository.findByPlaca(placa);
    }

    public List<Movimento> listParkedCars(){
        return movimentoRepository.findParkedCars();
    }

}
