package com.example.adi.playforlearn10;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adi.playforlearn10.Alunno.HomeAlunno;

import java.util.HashMap;
public class LoginActivityRaffaele extends AppCompatActivity implements View.OnClickListener  {


    public static final String USER_NAME = "USER_NAME";

    public static final String PASSWORD = "PASSWORD";
    public static final String url="192.168.1.69";
    private static final String LOGIN_URL = "http://192.168.1.69:80/webservice/loginMaestra.php";

    private EditText editTextUserName;
    private EditText editTextPassword;

    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_raffaele);

        editTextUserName = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.buttonUserLogin);

        buttonLogin.setOnClickListener(this);
    }


    private void login(){
        String username = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        userLogin(username,password);
    }

    private void userLogin(final String username, final String password){
        class UserLoginClass extends AsyncTask<String,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivityRaffaele.this,"Please Wait",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(LoginActivityRaffaele.this, HomeAlunno.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivityRaffaele.this,s,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                data.put("username",params[0]);
                data.put("password",params[1]);

                RegistrazioneUtenteClasse ruc = new RegistrazioneUtenteClasse();

                String result = ruc.sendPostRequest(LOGIN_URL,data);

                return result;
            }
        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(username,password);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
            login();
        }
    }

    public void registrati(View v){
        Intent i = new Intent(getApplicationContext(), RegUtente.class);
        startActivity(i);
        finish();
    }
}

