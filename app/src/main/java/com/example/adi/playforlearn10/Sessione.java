package com.example.adi.playforlearn10;

import com.example.adi.playforlearn10.Giochi.Gioco;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adi on 12/01/2017.
 *///sessione di gioco

public class Sessione  implements Serializable{
    private ArrayList<Gioco> giochiSessione;
    private transient static int id = 0;
    private int erroriTotali;
    private int indice;

    public Sessione(int id, ArrayList<Gioco> giochiSessione) {
        this.giochiSessione = giochiSessione;
        this.erroriTotali=0;
        this.id= id;
        int  indice=0;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setGiochiSessione(ArrayList<Gioco> giochiSessione) {
        this.giochiSessione = giochiSessione;
    }

    public static void setId(int id) {
        Sessione.id = id;
    }

    public void setErroriTotali(int erroriTotali) {
        this.erroriTotali = erroriTotali;
    }

    public ArrayList<Gioco> getGiochiSessione() {

        return giochiSessione;
    }

    public static int getId() {
        return id;
    }

    public int getErroriTotali() {
        return erroriTotali;
    }
}
