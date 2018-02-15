package com.example.adi.playforlearn10.Insegnate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.Record.RecordTop10;
import com.example.adi.playforlearn10.SezioneClassi;

/**HomeMaestra è la classe che si interfaccia con l'intero sistema PlayForLearn. Permette la visualizzazione delle varie materie
 * di un insegnante e un pulsante per la visualizzazione della top10 degli alunni.
 */

public class HomeMaestra extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_maestra);

        getSupportActionBar().setTitle("Home Maestra");
    }

    public void italiano(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void matematica(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void inglese(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void storia(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void geografia(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void account(View v){
        Intent i = new Intent(getApplicationContext(),AccountMaestra.class);
        startActivity(i);
        finish();
    }

    public void top10(View v){
        Intent i = new Intent(getApplicationContext(), RecordTop10.class);
        startActivity(i);
        finish();
    }
    //TODO javadoc
}
