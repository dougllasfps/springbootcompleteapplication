package org.dougllas.springboot.controller;

import org.dougllas.springboot.model.Convidado;
import org.dougllas.springboot.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by DOUGLLAS SOUSA on 20/09/2017.
 */

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/convidado", method = RequestMethod.POST)
    public String save(
            @RequestParam("nome") String nome,
            @RequestParam("nome") String email,
            @RequestParam("nome") String telefone,
            Model model){

        convidadoRepository.save( new Convidado(nome, email, telefone) );
        model.addAttribute("convidados", convidadoRepository.findAll());
        return "listaconvidados";
    }

    @RequestMapping("/listaconvidados")
    public String listaConvidados(Model model){
        return "listaconvidados";
    }
}
