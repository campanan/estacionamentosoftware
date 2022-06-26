package com.testetitan.services;


import com.testetitan.entities.Valor;
import com.testetitan.repositories.ValorRepository;
import com.testetitan.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class ValorService {

    @Autowired
    private ValorRepository valorRepository;

    private final Utils utils;

        public Valor findById(Integer id){
          return utils.findValorOrThrowNotFound(id, valorRepository);
    }


}
