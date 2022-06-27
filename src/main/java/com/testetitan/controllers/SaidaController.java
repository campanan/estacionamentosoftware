package com.testetitan.controllers;

import com.testetitan.entities.Movimento;
import com.testetitan.mapper.Mapper;
import com.testetitan.services.MovimentoService;
import com.testetitan.services.ValorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("/saida")
@NoArgsConstructor
@AllArgsConstructor
public class SaidaController {


    @Autowired
    private MovimentoService movimentoService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ValorService valorService;

    @GetMapping("/{placa}")
    public String saida(Model model,@PathVariable String placa){
        model.addAttribute("movimento", movimentoService.findByPlaca(placa));
        return "saida";
    }

    @PostMapping("/{placa}")
    public RedirectView saidaCarro(@ModelAttribute Movimento movimento, @PathVariable String placa, Model model){
        int idCarro = movimentoService.findByPlaca(placa).getId();
        String modeloCarro = movimentoService.findByPlaca(placa).getModelo();
        LocalDateTime horaEntrada = movimentoService.findByPlaca(placa).getHorarioEntrada();
        LocalDateTime horaSaida = LocalDateTime.now();
        Duration duration = Duration.between(horaEntrada,horaSaida);
        int horaTotal = (int)duration.toHours();
        int minutesTotal = ((int) duration.toMinutes()-(horaTotal*60));
        LocalTime horasDePermanencia = LocalTime.of(horaTotal,minutesTotal);
        float valorDemaisHoras = valorService.findById(1).getValorDemaisHoras();
        float valorPrimeiraHora = valorService.findById(1).getValorPrimeiraHora();
        float valorTotal = (horaTotal * valorDemaisHoras) + valorPrimeiraHora;
        Movimento movimentoSaida = new Movimento(idCarro,placa,modeloCarro,horaEntrada,horaSaida, horasDePermanencia, valorTotal);
        movimentoService.insertMovimento(movimentoSaida);
        model.addAttribute("movimento", movimentoSaida);
        return new RedirectView("/saida/{placa}");
    }




}
