package com.testetitan.controllers;

import com.testetitan.entities.Movimento;
import com.testetitan.entities.MovimentoDTO;
import com.testetitan.mapper.Mapper;
import com.testetitan.services.MovimentoService;
import com.testetitan.services.ValorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/alterar")
@RequiredArgsConstructor
public class AlterarController {

    @Autowired
    private MovimentoService movimentoService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ValorService valorService;

    @GetMapping("/{id}")
    public String alterar(Model model, @PathVariable Integer id){
        model.addAttribute("movimento", movimentoService.findById(id));
        model.addAttribute("movimento",new Movimento());

        return "alterar";
    }


    @PostMapping("/{id}")
    public RedirectView alterarEntrada(@ModelAttribute MovimentoDTO movimentoDTO, @PathVariable Integer id, Model model){
        model.addAttribute("movimentoDTO", movimentoDTO);
        Movimento movimentoAntigo = movimentoService.findById(id);
        movimentoAntigo.setPlaca(movimentoDTO.getPlaca());
        movimentoAntigo.setModelo(movimentoDTO.getModelo());
        movimentoService.insertMovimento(movimentoAntigo);
        return new RedirectView("home");
    }

}
