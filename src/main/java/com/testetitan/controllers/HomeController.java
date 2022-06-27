package com.testetitan.controllers;

import com.testetitan.mapper.Mapper;
import com.testetitan.services.MovimentoService;
import com.testetitan.services.ValorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private final MovimentoService movimentoService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ValorService valorService;

    @GetMapping
    public String showParkedCars(Model model){
        model.addAttribute("movimentos",movimentoService.listParkedCars());
        return "home";
    }
    @GetMapping("/alterar")
    public String alterar(Model model, String placa) {
        model.addAttribute("movimento", movimentoService.findByPlaca(placa));
        return "alterar";
    }




}
