package com.projeto.servidor.controller;

import java.util.List;
import com.projeto.servidor.service.Frases;
import com.projeto.servidor.service.Limpador;
import com.projeto.servidor.model.Placar;
import com.projeto.servidor.repository.PlacarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Principal
 */
@RestController
@RequestMapping("/")
public class Principal {

    @Autowired
    PlacarRepository placarRepository;

    @GetMapping("/frase")
    public String frase(Integer indice) {

        Frases frases = new Frases();

        if (indice == null) {
            return frases.pegarFraseAleatoria();
        } else {
            return frases.pegarFrasePorIndice(indice);
        }

    }

    @PostMapping("/placar")
    public String placar(@RequestBody String placar) {

        Limpador.limpar(placar).stream().forEach(item -> {

            Placar temp = new Placar();
            temp.setNome(item.split("-")[0]);
            temp.setPontuaçao(Integer.parseInt(item.split("-")[1]));

            placarRepository.save(temp);
        });

        return "salvo";
    }

    @GetMapping("/placar")
    public List<Placar> buscar() {
        return placarRepository.findAll();
    }
}