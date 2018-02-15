package com.example.adi.playforlearn10.Giochi;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.Record.RecordPersonali;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.adi.playforlearn10.Alunno.HomeAlunno.GEOGRAFIA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.INGLESE;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.ITALIANO;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.MATEMATICA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.MATERIA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.STORIA;

/**
 * Created by Adi on 18/01/2017.
 */

public class ActivityGiocoStoGioIng extends AppCompatActivity implements Serializable{
    private String nome, materia, classe;
    int errori, numEs, record;
    ArrayList<Gioco_StoGeoIng> giochiDaLanciare;
    private Drawable icona;
    Integer immagine;
    Gioco_StoGeoIng gioco;
    public Button bt1, bt2, bt3, bt4;

    public String soluzione,opzione1, opzione2, opzione3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numEs= getIntent().getIntExtra("Indice", 0);
        errori= getIntent().getIntExtra("errori", errori);
        record= getIntent().getIntExtra("record",errori);
        setContentView(R.layout.activity_gioco);
        bt2 = (Button) findViewById(R.id.bt2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        giochiDaLanciare= new ArrayList<Gioco_StoGeoIng>();
        materia= getIntent().getStringExtra("MATERIA");
        Log.d("DEBUG", materia);
        //Gioco_StoGeoIng gioco= new Gioco_StoGeoIng(icona,  nome,  materia, classe, errori, immagine, soluzione,  opzione1, opzione2,  opzione3);

        if(materia.compareTo(STORIA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_lampada,"Lampada","Letto","Divano","Sedia"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_letto,"Letto","Tavolo","Divano","Sedia"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_padella,"Padella","Piatto","Tavolo","Cucchiaio"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_vasca,"Vasca","Water","Sedia","Scrivania"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.cane, "Cane", "Pizza", "Colore", "Cosa"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_vasca,"Vasca","Water","Sedia","Scrivania"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.cane, "Cane", "Pizza", "Colore", "Cosa"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.graffiti, "Graffiti", "fiume", "computer", "fiore"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.casa, "Casa", "Piscina", "Cortile", "Pallone"));
        }
        else if(materia.compareTo(GEOGRAFIA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "Prato", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.sole, "Sole", "Sardegna", "Sardina", "mamma"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "Prato", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.stelle, "Stelle", "mappa", "cappa", "mamma"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.mare, "Mare", "pesce", "carne", "posto"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.pietra, "pietra","animale", "penna", "pingu" ));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.montagna, "Montagna", "heidi", "capre", "fiume"));
        }
        else if(materia.compareTo(INGLESE)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "Prato", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "Prato", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "Prato", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.prato, "flowers", "animale", "penna", "pingu"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.sole, "Sun", "Sardegna", "Sardina", "mamma"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.stelle, "Stars", "mappa", "cappa", "mamma"));

        } else if(materia.compareTo(MATEMATICA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.images, "15", "a", "d", "casa"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.calcoli, "55", "125", "60", "kiwi"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.ombra_ciclisti, "C G F", "125", "nessuna", "kiwi"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.ombra_sciatori, "A B H", "125", "nessuna", "kiwi"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.ombra_sciatori, "A B H", "125", "nessuna", "kiwi"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.ombra_cavallo, "C I J", "ciuccio", "galoppiamo", "nessuno"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.sfere, "7", "appari drago", "1", "5"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.sfere, "7", "appari drago", "1", "5"));

        }

        gioco= giochiDaLanciare.get(numEs);
        ArrayList<String> opzioni = new ArrayList<String>(4);
        opzioni.add(gioco.getSoluzione());
        opzioni.add(gioco.getOpzione1());
        opzioni.add(gioco.getOpzione2());
        opzioni.add(gioco.getOpzione3());
        ArrayList<Button> pulsanti = new ArrayList<Button>(4);
        pulsanti.add(bt1);
        pulsanti.add(bt2);
        pulsanti.add(bt3);
        pulsanti.add(bt4);
        setOptions(opzioni, pulsanti);

        //   esercizi.add(esercizi di storia);
        //}
        makeBind();
    }
    private void setOptions(ArrayList<String> opzioni, ArrayList<Button> pulsanti) {
        int p = 0, o = 0;
        for (int i = 0; i < 4; i++) {
            p = getRandomInt(pulsanti.size());
            o = getRandomInt(opzioni.size());
            pulsanti.get(p).setText(opzioni.get(o));
            pulsanti.remove(p);
            opzioni.remove(o);
        }
    }

    private void makeBind() {
        ImageView imageView = (ImageView) findViewById(R.id.ivImmagine);
        imageView.setImageResource((giochiDaLanciare.get(numEs)).getImmagine());
        //imageView.refreshDrawableState();

        MyOnClick myOnClick= new MyOnClick();
        bt1.setOnClickListener(myOnClick);
        bt2.setOnClickListener(myOnClick);
        bt3.setOnClickListener(myOnClick);
        bt4.setOnClickListener(myOnClick);
    }

    public  class MyOnClick implements View.OnClickListener {
        public void onClick(View v) {
            Button bt= (Button)v;
            checkSoluzione(giochiDaLanciare.get(numEs),bt.getText().toString());
            // numEs++;
            avviaSuccessivoOFine();
        }
    }
    //TODO controllo su quale layout caricare
    public boolean checkSoluzione(Gioco_StoGeoIng gioco, String opzione){
        if(opzione.compareTo(gioco.getSoluzione())==0){
            record++;
            avviaSuccessivoOFine();
            return  true;
        }else{
            errori++;
            avviaSuccessivoOFine();
            return false;
        }
    }
    public void avviaSuccessivoOFine() {
        if (numEs <= 7){
            Intent i = new Intent(this, ActivityGiocoStoGioIng.class);
            i.putExtra("Indice", numEs+1);
            i.putExtra(MATERIA, materia);
            i.putExtra("errori", errori);
            i.putExtra("record", record);
            startActivity(i);
            finish();
        }else if (numEs >7){
            //salvaRecord(record);
            Intent i = new Intent(getApplicationContext(), FineGioco.class);
            i.putExtra("errori", errori);
            i.putExtra("record", record);
            i.putExtra("MATERIA",materia);
            startActivity(i);
            finish();
        }
    }

    /*public void fine(){
        Intent i = new Intent(getApplicationContext(), FineGioco.class);
        i.putExtra("errori", errori);
        i.putExtra("record", record);
    }*/

    private Integer getRandomInt(int max) {
        int n = ((int) Math.round(Math.random() * max) % max);
        if (n >= 0) Log.d("DEBUG", "Il numero casuale scelto è " + n);
        return n >= 0 ? n : max - 1;
    }

    public void salvaRecord(int record){
        //TODO salvataggio
        /**
         * salvo il valore del record alla fine della giocata e lo salvo sul db
         */
        /*switch (materia){
            case ITALIANO:
                RecordPersonali.recorditaliano.add(record);
                break;
            case MATEMATICA:
                RecordPersonali.recordmatematica.add(record);
                break;
            case  INGLESE:
                RecordPersonali.recordinglese.add(record);
                break;
            case STORIA:
                RecordPersonali.recordstoria.add(record);
                break;
            case GEOGRAFIA:
                RecordPersonali.recordgeografia.add(record);
                break;
        }*/

    }
}
