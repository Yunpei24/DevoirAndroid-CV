package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.projetcvoffreemploie.httpconfig.Api;
import sn.esmt.projetcvoffreemploie.httpconfig.UsersCVApiResponse;
import sn.esmt.projetcvoffreemploie.ipconfig.Ip;

public class AccessListCVActivity extends AppCompatActivity {


    private EditText emailTxt;
    private EditText nomTxt;
    private EditText prenomTxt;
    private Button loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_list_cvactivity);

        emailTxt = (EditText) findViewById(R.id.editTextEmail);
        nomTxt = (EditText) findViewById(R.id.editTextNom);
        prenomTxt =(EditText) findViewById(R.id.editTextPrenom);
        loginBt = (Button) findViewById(R.id.loginButton);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ip ipAddresse = new Ip();
                String email = emailTxt.getText().toString();
                String nom = nomTxt.getText().toString();
                String prenom = prenomTxt.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ipAddresse.getIp())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<UsersCVApiResponse> call = api.login(email, nom, prenom);

                call.enqueue(new Callback<UsersCVApiResponse>() {
                    @Override
                    public void onResponse(Call<UsersCVApiResponse> call, Response<UsersCVApiResponse> response) {
                        if(response.isSuccessful()){
                            Log.d("Response :", response.body().toString());
                            String message = response.body().getMessage();
                            //String email = response.body().getEmail();
                            emailTxt.setText("");
                            nomTxt.setText("");
                            prenomTxt.setText("");
                            if(message.equals("OK")){
                                Intent intent = new Intent(AccessListCVActivity.this, VisualisationActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(AccessListCVActivity.this, "Cet Utilisateur n'existe pas!", Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Log.d("error message exception", response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<UsersCVApiResponse> call, Throwable t) {
                        Log.d("Error : ", t.getMessage());
                        Toast.makeText(AccessListCVActivity.this, "Impossible d'accéder au serveur !", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}