package com.testetitan.controllers;

import com.testetitan.entities.Movimento;
import com.testetitan.entities.MovimentoDTO;
import com.testetitan.entities.Valor;
import com.testetitan.mapper.Mapper;
import com.testetitan.services.MovimentoService;
import com.testetitan.services.ValorService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("estacionamento")
@RequiredArgsConstructor
public class MovimentoController {

    @Autowired
    private final MovimentoService movimentoService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ValorService valorService;

    @GetMapping
    public ResponseEntity<List<Movimento>> listAll(){
        return ResponseEntity.ok(movimentoService.listAll());
    }

    @GetMapping(path="/parked")
    public ResponseEntity<List<Movimento>> listParked(){
        return ResponseEntity.ok(movimentoService.listParkedCars());
    }

    @PostMapping
    public ResponseEntity<Movimento> save(@RequestBody @Valid MovimentoDTO movimentoDTO){

        Movimento movimento = mapper.toMovimento(movimentoDTO);

        movimentoService.insertMovimento(movimento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movimento.getId()).toUri();
        return ResponseEntity.created(uri).body(movimento);
    }

    @GetMapping(path = "/{placa}")
    public ResponseEntity findMovimentoByPlaca(@PathVariable(value = "placa") String placa){
        return ResponseEntity.ok(movimentoService.findByPlaca(placa));
    }



    @PutMapping(path = "/saida/{placa}")
    public ResponseEntity<Movimento> saidaCarro(@PathVariable String placa){
        int idCarro = movimentoService.findByPlaca(placa).getId();
        String modeloCarro = movimentoService.findByPlaca(placa).getModelo();
        LocalDateTime horaEntrada = movimentoService.findByPlaca(placa).getHorarioEntrada();
        LocalDateTime horaSaida = LocalDateTime.now();
        Integer horaTotal = horaSaida.getHour() - horaEntrada.getHour();
        Integer minutosTotal = horaSaida.getMinute() - horaEntrada.getMinute();
        LocalTime horasDePermanencia = LocalTime.of(horaTotal,minutosTotal);
        float valorPrimeiraHora = valorService.findById(1).getValorPrimeiraHora();
        float valorDemaisHoras = valorService.findById(1).getValorDemaisHoras();

        float valorTotal = (horaTotal * valorDemaisHoras) + valorPrimeiraHora;

        Movimento movimentoSaida = new Movimento(idCarro,placa,modeloCarro,horaEntrada,horaSaida, horasDePermanencia, valorTotal);

        movimentoService.insertMovimento(movimentoSaida);



        return ResponseEntity.ok().body(movimentoSaida);
    }



}
