package com.projeto.servidor.service;

import java.util.ArrayList;
import java.util.stream.Stream;


/**
 * Limpador
 */
public class Limpador {

    public static ArrayList<String> limpar(String placar) {

        ArrayList<String> conteudo = new ArrayList<>();

        placar = placar.replace("placar%5B%5D=", "");

        String[] listaPlacar = placar.split("&");

        Stream.of(listaPlacar).forEach(item -> {
            String nome = item.split("-")[0];
            String pontuaçao = item.split("-")[1];

            conteudo.add(nome + "-" + pontuaçao);
        });

        return conteudo;
    }
}