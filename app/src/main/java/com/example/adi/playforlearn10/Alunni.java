package com.example.adi.playforlearn10;

/**
 * Alunni è una classe public che rappresenta la lista degli alunni presenti all'interno di una singola classe. Ha vari
 * metodi get e set che rappresentano il nome e il record del singolo alunno.
 *
 */

public class Alunni {
    String nome, punteggio;

    public Alunni(String nome, String punteggio) {
        this.nome = nome;
        this.punteggio = punteggio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPunteggio() {
        return punteggio;
    }
}

//todo javadoc