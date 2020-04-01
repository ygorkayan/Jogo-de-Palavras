package com.projeto.servidor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Placar
 */
@Entity
public class Placar {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer pontuaçao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuaçao() {
        return pontuaçao;
    }

    public void setPontuaçao(Integer pontuaçao) {
        this.pontuaçao = pontuaçao;
    }
    
    
}