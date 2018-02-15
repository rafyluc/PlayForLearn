package com.example.adi.playforlearn10;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.adi.playforlearn10.Insegnate.HomeMaestra;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ListaAlunni2 è una classe che rappresenta la lista degli alunni della classe "Seconda" con i rispettivi record. La classe
 * viene gestita dal json che è un semplice formato per lo scambio di dati. Il json restituirà alla fine l'username e il
 * record del singolo utente.
 */

public class ListaAlunni2 extends AppCompatActivity {
    private static ArrayList<Alunni> alunni;
    AlunniListAdapter customAdapter;
    AlertDialog.Builder miaAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunni);
        getSupportActionBar().setTitle("Lista Alunni");
        miaAlert = new AlertDialog.Builder(this);
        popola();
    }

    private void setTextLista() {
        ListView ll = (ListView) findViewById(R.id.lista);
        customAdapter=new AlunniListAdapter(ListaAlunni2.this, R.layout.lista_row, alunni);
        ll.setAdapter(customAdapter);
    }


    private void popola() {
        new AsyncTask<Object, Object, Object>() {

            @Override
            protected void onPreExecute() {
                alunni = new ArrayList<Alunni>(10);
            }

            @Override
            protected Object doInBackground(Object... params) {
                String nome, record;
                try {
                    String ip = LoginActivityRaffaele.url;
                    int porta = 80;
                    String nomeFile = "webservice/lista2.php";
                    URL url = new URL("http", ip, porta, nomeFile);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    Scanner scanner = new Scanner(connection.getInputStream());
                    String response = "";
                    JSONObject obj = null;
                    while (scanner.hasNext()) {
                        response = scanner.nextLine();
                        obj = new JSONObject(response);
                        Log.d("DEBUG_response",response);
                        nome = obj.getString("fk_username");
                        record = obj.getString("record");
                        alunni.add(new Alunni(nome,record));
                        //  alunni.add(new Alunni(nome,record));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                setTextLista();
            }
        }.execute();
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), HomeMaestra.class);
        startActivity(i);
        finish();
    }
}