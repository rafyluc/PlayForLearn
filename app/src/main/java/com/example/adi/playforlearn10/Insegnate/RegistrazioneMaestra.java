package com.example.adi.playforlearn10.Insegnate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adi.playforlearn10.LoginActivityRaffaele;
import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.RegistrazioneUtenteClasse;

import java.util.HashMap;

/**
 * RegistrazioneMaestra è una classe public che consente di registrare un account Amministratore nel sistema PlayForLearn.
 * Inserendo le varie informazioni che richiede il sistema e cliccando sul bottone registrati, il sistema registra un nuovo
 * account.
 */

public class RegistrazioneMaestra extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText username_us,nome_no,cognome_co,password_pa;
    private static final String REGISTER_URL ="http://172.19.58.62:80/webservice/addUtente.php";
    private ImageButton registrati, annulla;
    public static final String SharedPrefName = "Shared";
    CheckBox ch1,ch2,ch3,ch4;
    boolean scelta;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione_maestra);
        annulla =(ImageButton)findViewById(R.id.btAnnulla);
        annulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), LoginActivityRaffaele.class);
            }
        });
        username_us=(TextInputEditText)findViewById(R.id.username1);
        password_pa=(TextInputEditText)findViewById(R.id.password1);
        nome_no=(TextInputEditText)findViewById(R.id.nome1);
        cognome_co=(TextInputEditText)findViewById(R.id.cognome1);
        ch1=(CheckBox)findViewById(R.id.checkBox1);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        ch3=(CheckBox)findViewById(R.id.checkBox3);
        ch4=(CheckBox)findViewById(R.id.checkBox4);

        InputFilter filter = new InputFilter() {
            /**
             * Questo metodo CharSequence permette di creare un inputFilter per i campi Nome e Cognome durante la registrazione
             * di un account Amministratore, in modo tale da non far inserire caratteri speciali o numeri all'interno del nome
             * e del cognome.
              * @param source prende la stringa carattere per carattere
             * @param start inizio stringa
             * @param end fine stringa
             * @param dest rende la stringa immutabile.
             * @param dstart
             * @param dend
             * @return Character.isLetter(c) || Character.isSpaceChar(c); la stringa può contenere lettere dell'alfabeto o spazi
             * bianchi.
             */
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                boolean keepOriginal = true;
                StringBuilder sb = new StringBuilder(end - start);
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    boolean d=isCharAllowed(c);
                    if (d)
                        sb.append(c);
                    else
                        keepOriginal = false;
                }
                if (keepOriginal)
                    return null;
                else {
                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(sb);
                        TextUtils.copySpansFrom((Spanned) source, start, sb.length(), null, sp, 0);
                        return sp;
                    } else {
                        return sb;
                    }
                }
            }

            private boolean isCharAllowed(char c) {
                return Character.isLetter(c) || Character.isSpaceChar(c);
            }
        };
        nome_no.setFilters(new InputFilter[]{filter});
        cognome_co.setFilters(new InputFilter[]{filter});


        registrati=(ImageButton)findViewById(R.id.registrazioneMaestra);
        getSupportActionBar().setTitle("Registrazione Utente_Maestra");

        registrati.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == registrati){
            Log.d("DEBUG_us",username_us.getText().toString());
            Log.d("DEBUG_pw",password_pa.getText().toString());
            Log.d("DEBUG_nome",nome_no.getText().toString());
            Log.d("DEBUG_surname",cognome_co.getText().toString());

            if(username_us.getText().toString().equals("")|| nome_no.getText().toString().equals("")|| cognome_co.getText().toString().equals("")
                    || password_pa.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Inserire tutti i campi!",Toast.LENGTH_SHORT).show();
            } else {
                registraUtente();
                SharedPreferences prefs = RegistrazioneMaestra.this.getSharedPreferences("Shared", 0);
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("username", RegistrazioneMaestra.this.username_us.getText().toString());
                prefsEditor.putString("password", RegistrazioneMaestra.this.password_pa.getText().toString());
                prefsEditor.putString("nome", RegistrazioneMaestra.this.nome_no.getText().toString());
                prefsEditor.putString("cognome", RegistrazioneMaestra.this.cognome_co.getText().toString());
                prefsEditor.commit();
            }
        }
    }



    private void registraUtente() {
        String username = username_us.getText().toString().trim().toLowerCase();
        String nome = nome_no.getText().toString().trim().toLowerCase();
        String cognome = cognome_co.getText().toString().trim().toLowerCase();
        String password = password_pa.getText().toString().trim().toLowerCase();
        registra(username,nome,cognome,password);
    }

    /**
     * Metodo registra che permette la registrazione dell'utente prendendosi i campi Username, nome,cognoe e password
     * inseriti dall'utente al momento della registrazione.
     * @param username
     * @param nome
     * @param cognome
     * @param password
     * @return result l'inserimento è avvenuto con successo.
     */
    private void registra(final String username, final String nome, final String cognome, final String password) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegistrazioneUtenteClasse ruc = new RegistrazioneUtenteClasse();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegistrazioneMaestra.this, "Aspetta",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegistrazioneMaestra.this, AccountMaestra.class);
                startActivity(intent);
                finish();
            }



            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("us",params[0]);
                data.put("name",params[1]);
                data.put("surname",params[2]);
                data.put("password",params[3]);
                Log.d("DEBUG_data", String.valueOf(data));
                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }

        }

        RegisterUser ru = new RegisterUser();
        ru.execute(username,nome,cognome,password);//TODO manca la materia
    }

    public void annulla(View v){
        username_us.setText("");
        password_pa.setText("");
        nome_no.setText("");
        cognome_co.setText("");
    }
    //TODO javadoc
}

