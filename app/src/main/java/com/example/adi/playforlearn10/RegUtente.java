package com.example.adi.playforlearn10;

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
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adi.playforlearn10.Alunno.AccountAlunno;

import java.util.HashMap;

/**
 * RegUtente è una classe public che consente di registrare un account Alunno nel sistema PlayForLearn.
 * Inserendo le varie informazioni che richiede il sistema e cliccando sul bottone registrati, il sistema registra un nuovo
 * account.
 */

public class RegUtente extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText usr,psw,name,surname;
    private static final String REGISTER_URL ="http://192.168.1.69:80/webservice/addUtenteAlunno.php";
    private ImageButton registrati;
    private RadioGroup radio;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrati);

        usr=(TextInputEditText)findViewById(R.id.username);
        psw=(TextInputEditText)findViewById(R.id.password);
        name=(TextInputEditText)findViewById(R.id.nome);
        surname=(TextInputEditText)findViewById(R.id.cognome);
        InputFilter filter = new InputFilter() {
            /**
             * Questo metodo CharSequence permette di creare un inputFilter per i campi Nome e Cognome durante la registrazione
             * di un account Amministratore, in modo tale da non far inserire caratteri speciali o numeri all'interno del nome
             * e del cognome.
             * @param source
             * @param start inizio stringa
             * @param end fine stringa
             * @param dest
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
        name.setFilters(new InputFilter[]{filter});
        surname.setFilters(new InputFilter[]{filter});


        radio=(RadioGroup)findViewById(R.id.radio);
        registrati=(ImageButton)findViewById(R.id.btOK);
        getSupportActionBar().setTitle("Registrazione Utente");

        registrati.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == registrati){
            if(usr.getText().toString().equals("")|| name.getText().toString().equals("")|| surname.getText().toString().equals("")|| psw.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Inserire tutti i campi!",Toast.LENGTH_SHORT).show();
            } else {
                registraUtente();
                SharedPreferences prefs = RegUtente.this.getSharedPreferences("Shared", 0);
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("username", RegUtente.this.usr.getText().toString());
                prefsEditor.putString("password", RegUtente.this.psw.getText().toString());
                prefsEditor.putString("nome", RegUtente.this.name.getText().toString());
                prefsEditor.putString("cognome", RegUtente.this.surname.getText().toString());
                prefsEditor.commit();
            }
        }
    }



    public void registraUtente() {
        String username = usr.getText().toString().trim().toLowerCase();
        String nome = name.getText().toString().trim().toLowerCase();
        String cognome = surname.getText().toString().trim().toLowerCase();
        String password = psw.getText().toString().trim().toLowerCase();
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
                loading = ProgressDialog.show(RegUtente.this, "Aspetta",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                 loading.dismiss();
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegUtente.this, AccountAlunno.class);
                    startActivity(intent);
                    finish();
                }



            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("usr",params[0]);
                data.put("name",params[1]);
                data.put("surname",params[2]);
                data.put("psw",params[3]);
                String result = ruc.sendPostRequest(REGISTER_URL,data);
                return  result;
            }

        }

        RegisterUser ru = new RegisterUser();
        ru.execute(username,nome,cognome,password);
    }

    public void annulla(View v){
        usr.setText("");
        psw.setText("");
        name.setText("");
        surname.setText("");
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), LoginActivityRaffaele.class);
        startActivity(i);
        finish();
    }
}
