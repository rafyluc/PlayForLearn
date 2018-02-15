package com.example.adi.playforlearn10.Giochi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.adi.playforlearn10.R;

/**
 * Classe suggerimento rappresenta il suggerimento offerto all'utente inerente alla domanda di cui vuole
 * conoscere la riposta corretta.
 */
public class Suggerimento extends AppCompatActivity {
    private TextView textViewQuesito;
    private TextView textViewRisposta;
    private String quesito;
    private boolean risposta;
    private boolean rispostaMostrata = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_suggerimento);

        textViewQuesito = (TextView) findViewById(R.id.testoQuesito);
        textViewRisposta = (TextView) findViewById(R.id.testoRisposta);

        Intent i = getIntent();
        quesito = i.getStringExtra("TESTO_QUESITO");
        risposta = i.getBooleanExtra("RISPOSTA_QUESITO", risposta);

        textViewQuesito.setText(quesito);
        setReturnIntent();
    }

    private void setReturnIntent() {
        Intent data = new Intent();
        data.putExtra("RISPOSTA_MOSTRATA", rispostaMostrata);
        setResult(RESULT_OK,data);
    }

    /**
     * Metodo onClickMostra mostra la risposta che può essere vera o falsa.
     * @param v
     */
    public void onClickMostra(View v) {
        textViewRisposta.setText(""+risposta);
        //rispostaMostrata = true;
        setReturnIntent();
    }

    public void onClickTorna(View v) {
        Intent i = new Intent(getApplicationContext(), DolceMatematica.class);
        startActivity(i);
        finish();
    }
}

