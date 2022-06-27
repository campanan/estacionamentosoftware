package com.testetitan.controllers;

import com.testetitan.entities.Movimento;
import com.testetitan.entities.MovimentoDTO;
import com.testetitan.mapper.Mapper;
import com.testetitan.services.MovimentoService;
import com.testetitan.services.ValorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class MovimentoController {

    @Autowired
    private final MovimentoService movimentoService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ValorService valorService;


    @GetMapping("entradaForm")
    public String entradaForm(Model model){
        model.addAttribute("movimentoDTO",new MovimentoDTO());

        return "/entradaForm";
    }


    @PostMapping("entradaForm")
    public RedirectView save(@ModelAttribute MovimentoDTO movimentoDTO, Model model){      ;
        model.addAttribute("movimentoDTO", movimentoDTO);
        Movimento movimento = mapper.toMovimento(movimentoDTO);
        movimentoService.insertMovimento(movimento);
        return new RedirectView("home");
    }



    @GetMapping(path = "/listar/{placa}")
    public ResponseEntity findMovimentoByPlaca(@PathVariable(value = "placa") String placa){
        return ResponseEntity.ok(movimentoService.findByPlaca(placa));
    }











}
