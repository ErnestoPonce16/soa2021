package com.epec.demo.controllers;

import com.epec.demo.business.IClienteBusiness;
import com.epec.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClienteController {
    @Autowired
    private IClienteBusiness clienteDao;

    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value="/formCliente")
    public String crear(Map<String,Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        model.put("titulo","Formulario de Cliente");
        return "formCliente";
    }

    @RequestMapping(value = "/formCliente", method=RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
