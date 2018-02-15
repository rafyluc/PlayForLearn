package com.example.adi.playforlearn10.Giochi;

/**
 * ResultActivity è una classe che rappresenta un semplice layout con il risultato di un singolo utente dopo aver giocato
 * l'intera partita. Verranno conteggiate le risposte esatte e salvato il record nel database.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.adi.playforlearn10.R;

public class ResultActivity extends Activity {
    String score2 = "";
    String score3 = "";
    SharedPreferences prefs;
    private boolean italiano,matematica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        italiano = prefs.getBoolean("italiano", false);
        matematica = prefs.getBoolean("matematica", false);
        Log.d("Debug_it",italiano+"");
        Log.d("Debug_it",matematica+"");
        TextView t = (TextView) findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        score2 = b.getString("activity1");
        score3 = b.getString("activity2");

        bar.setRating(score);

        t.setText("Il tuo score è " + " " + score + " " + "Grazie per aver giocato.");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    /**
     * Metodo rigioca che chiama l'intent dei giochi Quiz_Italiano o Dolce_Matematica
     * per poter rifare una partita.
     *
     * @param v pulsante rigioca
     */
    public void rigioca(View v) {

        Log.d("Debug: ",matematica+"");
        Log.d("Debug: ",italiano+"");

        if (matematica==true) {
            Intent i = new Intent(getApplicationContext(), DolceMatematica.class);
            startActivity(i);
            finish();
        } else if (italiano==true) {

            Intent i = new Intent(getApplicationContext(), QuizActivity.class);
            startActivity(i);
            finish();
        }

        }
}
