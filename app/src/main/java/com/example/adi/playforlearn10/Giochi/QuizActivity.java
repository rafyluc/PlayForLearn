package com.example.adi.playforlearn10.Giochi;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.adi.playforlearn10.R;

import java.util.List;

/**
 * QuizActivity è una classe che rappresenta il gioco Quiz_italiano dove vengono visualizzati i vari pulsanti di scelta
 * fra le varie opzioni offerte. Il gioco terminerà quando l'alunno avrà risposto a tutte le domande.
 */
public class QuizActivity extends Activity {
    List<Domande> lista;
    private boolean italiano,matematica;
    int score=0;
    int qid=0;
    Domande currentQ;
    SharedPreferences prefs;
    TextView txtQuestion,iniziaGioco;
    RadioButton rda, rdb, rdc;
    Button butNext;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db=new DbHelper(this);
        lista=db.getAllQuestions();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        matematica=false;
        italiano=true;
       // SharedPreferences prefs = QuizActivity.this.getSharedPreferences("Shared", 0);


        currentQ=lista.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        iniziaGioco=(TextView)findViewById(R.id.Inizia);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("la tua risposta", currentQ.getDomanda()+" "+answer.getText());
                if(currentQ.getRisposta().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Il tuo score"+score);
                }
                if(qid<10){
                    currentQ=lista.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    saveStateToPreferences();
                    intent.putExtra("score", score);
                    intent.putExtra("activity2","QuizActivity");
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getDomanda());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }


    private void saveStateToPreferences() {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putBoolean("matematica", matematica);
        prefsEditor.putBoolean("italiano", italiano);
        prefsEditor.commit();
    }
}
