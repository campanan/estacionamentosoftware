package com.testetitan.services;

import com.testetitan.entities.Movimento;
import com.testetitan.repositories.MovimentoRepository;
import com.testetitan.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Movimento findById(Integer id){
        Movimento movimento = movimentoRepository.findById(id).orElse(null);
        return movimento;
    }

    public List<Movimento> listParkedCars(){
        return movimentoRepository.findParkedCars();
    }

}
