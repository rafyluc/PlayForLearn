package com.example.adi.playforlearn10.Record;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adi.playforlearn10.Alunno.HomeAlunno;
import com.example.adi.playforlearn10.LoginActivityRaffaele;
import com.example.adi.playforlearn10.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordTop10 extends AppCompatActivity {
    private static ArrayList<Record> records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_top10);
        getSupportActionBar().setTitle("Top 10");
        popola();
    }

    private void setTextRecord() {
        ListView ll = (ListView)findViewById(R.id.lvRecords);
        ll.setAdapter(new RecordsListAdapter(RecordTop10.this,R.layout.record_row,records));
    }

    private void popola() {
        new AsyncTask<Object, Object, Object>() {

            @Override
            protected void onPreExecute() {
                records = new ArrayList<Record>(10);
            }

            @Override
            protected Object doInBackground(Object... params) {
                String nome, gioco, record;
                try {
                    String ip = LoginActivityRaffaele.url;
                    int porta = 80;
                    String nomeFile = "webservice/getTop10.php";
                    URL url = new URL("http", ip, porta, nomeFile);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    Scanner scanner = new Scanner(connection.getInputStream());
                    String response = "";
                    JSONObject obj = null;
                    while (scanner.hasNext()) {
                        response = scanner.nextLine();
                        obj = new JSONObject(response);
                        nome = obj.getString("fk_username");
                        gioco = obj.getString("nome_gioco");
                        record = obj.getString("record");
                        records.add(new Record(nome,gioco,record));
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
                setTextRecord();
            }
        }.execute();
    }

    private class RecordsListAdapter extends ArrayAdapter {
        public RecordsListAdapter(Context context, int resource, List objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.record_row,null);
            TextView tvNomeAlunno = (TextView)view.findViewById(R.id.tvNomeAlunno);
            TextView tvNomeGioco = (TextView)view.findViewById(R.id.tvNomeGioco);
            TextView tvRecord = (TextView)view.findViewById(R.id.tvRecord);
            Record record  = (Record)this.getItem(position);
            tvNomeAlunno.setText(record.getNome());
            tvNomeGioco.setText(record.getGioco());
            tvRecord.setText(record.getPunteggio());
            return view;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeAlunno.class));
        finish();
    }

    private class Record{
        String nome, gioco, punteggio;

        public Record(String nome, String gioco, String punteggio) {
            this.nome = nome;
            this.gioco = gioco;
            this.punteggio = punteggio;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getGioco() {
            return gioco;
        }

        public void setGioco(String gioco) {
            this.gioco = gioco;
        }

        public String getPunteggio() {
            return punteggio;
        }

        public void setPunteggio(String punteggio) {
            this.punteggio = punteggio;
        }
    }
}
//todo javadoc