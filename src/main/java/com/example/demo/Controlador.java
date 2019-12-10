package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controlador{
    @Autowired
    LembreteRepositorio crud;


    @RequestMapping ("/cadastro")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("cadastro.html");
        mv.addObject("gerenciadorLembrete", new GerenciadorLembrete());
        return mv;
    }
    @RequestMapping("/cadastro/salvar")
    public ModelAndView salvar(GerenciadorLembrete novoLembrete) {
        crud.save(novoLembrete);
        return new ModelAndView("redirect:/cadastro/listar");
    }


}
