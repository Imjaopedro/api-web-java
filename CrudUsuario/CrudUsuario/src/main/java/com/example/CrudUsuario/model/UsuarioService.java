package com.example.CrudUsuario.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAllOrderedById() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return repository.findAll(sort);
    }
}
