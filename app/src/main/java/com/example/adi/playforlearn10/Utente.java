package com.example.adi.playforlearn10;

/**
 * Created by Adi on 17/02/2017.
 */

public class Utente {
    String id, nome, cognome, password, username;

    public Utente(String id, String nome, String cognome, String password, String username) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

//todo javadoc