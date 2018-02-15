package com.example.adi.playforlearn10.Alunno;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adi.playforlearn10.Insegnate.RegistrazioneMaestra;
import com.example.adi.playforlearn10.LoginActivityRaffaele;
import com.example.adi.playforlearn10.R;

public class AccountAlunno extends AppCompatActivity {
    AlertDialog.Builder miaAlert;
    private TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        t1 = (TextView) findViewById(R.id.textNome);
        t2 = (TextView) findViewById(R.id.textCognome);
        t3 = (TextView) findViewById(R.id.textUsername);
        t4 = (TextView) findViewById(R.id.textPassword);
        ImageButton home=(ImageButton)findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeAlunno.class);// mettere il nuovo login
                startActivity(i);
                finish();
            }
        });

        SharedPreferences prefs = getSharedPreferences(RegistrazioneMaestra.SharedPrefName, 0);
        this.t3.setText(prefs.getString("username", "username non trovato"));
        this.t4.setText(prefs.getString("password", "passowrd non trovata"));
        this.t1.setText(prefs.getString("nome", "nome non trovato"));
        this.t2.setText(prefs.getString("cognome", "cognome non trovato"));

        getSupportActionBar().setTitle("Account Alunno");

        // TODO da completare
    }
        //ImageButton btLogout= (ImageButton)findViewById(R.id.btLogout);
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

    public void home(View v) {
        Intent i = new Intent(getApplicationContext(), HomeAlunno.class);
        startActivity(i);
        finish();
    }
        //sharedpreference da inserire


}
