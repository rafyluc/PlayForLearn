package com.example.adi.playforlearn10.Insegnate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.adi.playforlearn10.LoginActivityRaffaele;
import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.RegUtente;

/**
 * AccountMaestra è la classe che consente di visualizzare le informazioni inerenti ad ogni utente amministratore registratosi
 * nel sistema PlayForLearn. Le informazioni dell'utente sono : nome,cognome,username e password. Inoltre la suddetta classe
 * ha a disposizione una serie di pulsanti da cui:
 * -Permette di registrare un account utente.
 * -Permettere di fare il logout dal sistema e infine permette il logout del sistema.
 *
 */

public class AccountMaestra  extends AppCompatActivity {
    AlertDialog.Builder miaAlert;
    private TextView t1,t2,t3,t4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_maestra);
        miaAlert = new AlertDialog.Builder(this);
        t1=(TextView) findViewById(R.id.username);
        t2=(TextView) findViewById(R.id.password);
        t3=(TextView) findViewById(R.id.nome);
        t4=(TextView) findViewById(R.id.cognome);

        SharedPreferences prefs = getSharedPreferences(RegistrazioneMaestra.SharedPrefName, 0);
        this.t1.setText(prefs.getString("username", "username non trovato"));
        this.t2.setText(prefs.getString("password", "passowrd non trovata"));
        this.t3.setText(prefs.getString("nome", "nome non trovato"));
        this.t4.setText(prefs.getString("cognome", "cognome non trovato"));

        getSupportActionBar().setTitle("Account Maestra");

    }

    public void logout(View v){
        miaAlert.setTitle("Vuoi davvero uscire dal sistema?");
        miaAlert.setCancelable(false);
        miaAlert.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        miaAlert.setNegativeButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(getApplicationContext(), LoginActivityRaffaele.class);
                startActivity(i);
                finish();

            }
        });

        AlertDialog alert = miaAlert.create();
        alert.show();

    }


    public void aggiungiUtente(View v) {

        Intent i = new Intent(getApplicationContext(), RegUtente.class);
        startActivity(i);
        finish();
    }

    public void home(View v){
        Intent i=new Intent(getApplicationContext(),HomeMaestra.class);
        startActivity(i);
        finish();
    }
//TODO javadoc
}
