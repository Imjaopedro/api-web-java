package com.example.CrudUsuario.controller;

import com.example.CrudUsuario.model.Usuario;
import com.example.CrudUsuario.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Optional;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("usuario/novo")
    public String novo (Model model){


        return "usuario/formulario";
    }

    @PostMapping("usuario/novo")
    public String novo(Model model, Usuario usuario){
        usuario.setDataInclusao(Calendar.getInstance());
        Usuario novoUsuario = usuario;

        repository.save(novoUsuario);

        return "redirect:home";
    }


    @GetMapping("usuario/editar/{id}")
    public String editar(Model model, Usuario usuario, @PathVariable Long id){

        Optional<Usuario> usuarioAntigoOptional = repository.findById(id);

        Usuario usuarioAntigo = usuarioAntigoOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));




       model.addAttribute("usuario",usuarioAntigo );

        return "usuario/editar";
    }

    @PostMapping("usuario/editar/{id}")
    public String edita(Model model, @ModelAttribute Usuario usuario, @PathVariable Long id){

       Optional<Usuario> usuarioAntigoOptional = repository.findById(id);
        Usuario usuarioAntigo = usuarioAntigoOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioAntigo.setDataInclusao(usuario.getDataInclusao());
        usuarioAntigo.setHobby(usuario.getHobby());
        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setDataAlteracao(Calendar.getInstance());
        usuarioAntigo.setProfissao(usuario.getProfissao());

        repository.save(usuarioAntigo);

        return "redirect:/usuario/home";
    }

    @GetMapping("usuario/excluir/{id}")
    public String excluir(Model model, Usuario usuario, @PathVariable Long id){

        Optional<Usuario> usuarioAntigoOptional = repository.findById(id);

        Usuario usuarioAntigo = usuarioAntigoOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));




        model.addAttribute("usuario",usuarioAntigo );

        return "usuario/excluir";
    }

    @PostMapping("usuario/excluir/{id}")
    public String exclui(Model model, @ModelAttribute Usuario usuario, @PathVariable Long id){

        Optional<Usuario> usuarioAntigoOptional = repository.findById(id);
        Usuario usuarioAntigo = usuarioAntigoOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));


        repository.delete(usuarioAntigo);

        return "redirect:/usuario/home";
    }



}
