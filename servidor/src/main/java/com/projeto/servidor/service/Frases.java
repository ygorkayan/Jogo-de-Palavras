package com.projeto.servidor.service;

import java.util.ArrayList;
import java.util.Random;

/**
 * Frases
 */
public class Frases {

    private ArrayList<String> frases = new ArrayList<>();

    public Frases() {
        frases.add("Você me deu uma eternidade dentro dos nossos dias numerados-5");
        frases.add("Você é a resposta para todas as minhas orações. Você é uma canção, um sonho, um murmúrio, e não sei como consegui viver sem você durante tanto tempo.-5");
        frases.add("Odeio não conseguir te odiar por mais que eu tente ou por menos que você faça...-5");
        frases.add("Grandes poderes trazem grandes responsabilidades-5");
        frases.add("Nunca deixe que alguém te diga que não pode fazer algo. Nem mesmo eu. Se você tem um sonho, tem que protegê-lo-5");
        frases.add("Mantenha os seus amigos por perto, e os inimigos ainda mais perto-5");
        frases.add("Que a força esteja com você!-5");
        frases.add("Você me salvou de todas as maneiras que alguém pode ser salvo-5");
        frases.add("Ou você morre herói, ou vive o suficiente para se tornar o vilão-5");
        frases.add("É preciso muito audácia para enfrentarmos os nossos inimigos, mas igual audácia para defendermos os nossos amigos-5");
    }

    
    public void colocarFrase(String texto, int tempo) {
        frases.add(texto + "-" + tempo);
    }

    public String pegarFraseAleatoria() {
        Random gerador = new Random();

        int numeroAleatorio = gerador.nextInt(frases.size());

        return pegarFrasePorIndice(numeroAleatorio);
    }

    public String pegarFrasePorIndice(int indice) {
        return frases.get(indice);
    }
}