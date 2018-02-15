package com.example.adi.playforlearn10.Giochi;


import android.graphics.drawable.Drawable;

public class Gioco {
    private String nome, materia, classe;
    int errori;
    private Drawable icona;

    public Gioco(Drawable icona, String nome, String materia, String classe, int errori) {
        this.nome = nome;
        this.materia = materia;
        this.classe = classe;
        this.errori= errori;
        this.icona = icona;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getErrori() {
        return errori;
    }

    public void setErrori(int errori) {
        this.errori = errori;
    }

    public Drawable getIcona() {
        return icona;
    }

    public void setIcona(Drawable icona) {
        this.icona = icona;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
//TODO javadoc