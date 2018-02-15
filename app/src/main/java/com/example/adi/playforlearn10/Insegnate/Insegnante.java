package com.example.adi.playforlearn10.Insegnate;

import com.example.adi.playforlearn10.Utente;

import java.util.ArrayList;

/**
 * Insegnante è una classe che rappresenta un account Amministratore. Ha vari metodi get e set che permettono di visualizzare la
 * materia, la classe e le varie informazioni inerenti all'account Amministratore.
 */

public class Insegnante extends Utente {
    ArrayList<String> materia, classe;

    /**
     * Il costruttore insegnante prende in input vari parametri tra cui:
     * @param id :che rappresenta l'id dell'insegnante ed è univoco per ogni account Amministratore
     * @param nome :il nome dell'insegnante
     * @param cognome : il cognome dell'insegnante
     * @param password : codice alfanumerico per potersi loggare al sistema.
     * @param username : username unico per potersi loggare al sistema.
     * @param materia : materia che insegna quel relativo insegnante
     * @param classe : la classe che gli è stata assegnatosi
     */
    public Insegnante(String id, String nome, String cognome, String password, String username, ArrayList<String> materia, ArrayList<String>classe) {
        super(id, nome, cognome, password, username);
        this.materia = materia;
        this.classe= classe;
    }


    public ArrayList<String> getMateria() {
        return materia;
    }

    /**
     * Metodo getMateria che restituisce la materia che l'insegnante insegna.
     * @param materia
     * @return ArrayList<String></String>
     */
    public void setMateria(ArrayList<String> materia) {
        this.materia = materia;
    }

    public ArrayList<String> getClasse() {
        return classe;
    }

    /**
     * Metodo getClasse che restituisce la classe o le classi in cui insegna l'insegnante.
     * @param classe
     * @return ArrayList<String></String>
     */
    public void setClasse(ArrayList<String> classe) {
        this.classe = classe;
    }
}
