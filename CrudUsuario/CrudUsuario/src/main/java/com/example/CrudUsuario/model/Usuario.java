package com.example.CrudUsuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Calendar;

@Entity
@Table
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;



    @NotNull
    private String profissao;

    @NotNull
    private String hobby;


    private Calendar dataInclusao;
    private Calendar dataAlteracao;


    public Usuario() {
    }

    public Usuario(Long id, String nome, String profissao, String hobby, Calendar dataInclusao) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.hobby = hobby;
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Calendar getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Calendar dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Calendar getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Calendar dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }



}
