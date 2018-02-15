package com.example.adi.playforlearn10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * SezioneClassi è una classe che rappresenta una serie di pulsanti inerenti ad ogni singola classe
 * presente nell'istituto, dalla prima alla quinta classe.
 */

public class SezioneClassi extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_classi);

        getSupportActionBar().setTitle("Sezione Classi");
    }

    public void listaAlunni(View v){
        Intent i = new Intent(getApplicationContext(),ListaAlunni.class);
        startActivity(i);
        finish();
    }

    public void listaAlunni2(View v){
        Intent i = new Intent(getApplicationContext(),ListaAlunni2.class);
        startActivity(i);
        finish();
    }

    public void listaAlunni3(View v){
        Intent i = new Intent(getApplicationContext(),ListaAlunni3.class);
        startActivity(i);
        finish();
    }

    public void listaAlunni4(View v){
        Intent i = new Intent(getApplicationContext(),ListaAlunni4.class);
        startActivity(i);
        finish();
    }

    public void listaAlunni5(View v){
        Intent i = new Intent(getApplicationContext(),ListaAlunni5.class);
        startActivity(i);
        finish();
    }
}

//todo javadoc