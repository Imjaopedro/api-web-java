package com.example.CrudUsuario.controller;



import com.example.CrudUsuario.model.Usuario;
import com.example.CrudUsuario.model.UsuarioRepository;
import com.example.CrudUsuario.model.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("/usuario")
@RequestMapping("/usuario")
public class HomeController {


    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;
    @GetMapping("home")
    public String home(Model model){

        List<Usuario> usuarios = repository.findAll();

       usuarios = service.findAllOrderedById();

        model.addAttribute("usuarios",usuarios);


        return "home";
    }





}
