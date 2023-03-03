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
import sn.esmt.projetcvoffreemploie.httpconfig.UsersCVSend;
import sn.esmt.projetcvoffreemploie.ipconfig.Ip;

public class RegistryActivity extends AppCompatActivity {

    private EditText emailTxt;
    private EditText nomTxt;
    private EditText prenomTxt;
    private EditText ageTxt;
    private EditText adresseTxt;
    private EditText telephoneTxt;
    private EditText specialiteTxt;
    private EditText niveauEtudeTxt;
    private EditText experienceProfessionnelleTxt;
    private Button registerBtn;
    private Button retourBt;

    private UsersCVSend usersCVSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        emailTxt = (EditText) findViewById(R.id.emailTxt);
        nomTxt = (EditText) findViewById(R.id.nomTxt);
        prenomTxt =(EditText) findViewById(R.id.prenomTxt);
        ageTxt = (EditText) findViewById(R.id.ageTxt);
        adresseTxt = (EditText) findViewById(R.id.adresseTxt);
        telephoneTxt = (EditText) findViewById(R.id.telephoneTxt);
        specialiteTxt = (EditText) findViewById(R.id.specialiteTxt);
        niveauEtudeTxt = (EditText) findViewById(R.id.niveauEtudeTxt);
        experienceProfessionnelleTxt = (EditText) findViewById(R.id.experienceProfessionnelleTxt);

        registerBtn = (Button) findViewById(R.id.registryButton);
        retourBt = (Button) findViewById(R.id.retourButton);

        retourBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailTxt.getText().toString();
                String nom = nomTxt.getText().toString();
                String prenom = prenomTxt.getText().toString();
                int age = Integer.parseInt(ageTxt.getText().toString());
                String adresse = adresseTxt.getText().toString();
                String telephone = telephoneTxt.getText().toString();
                String specialite = specialiteTxt.getText().toString();
                String nivEtude = niveauEtudeTxt.getText().toString();
                String expProf = experienceProfessionnelleTxt.getText().toString();
                Ip ipAddress = new Ip();

                usersCVSend = new UsersCVSend();

                usersCVSend.setEmail(email);
                usersCVSend.setNom(nom);
                usersCVSend.setPrenom(prenom);
                usersCVSend.setAge(age);
                usersCVSend.setAdresse(adresse);
                usersCVSend.setTelephone(telephone);
                usersCVSend.setSpecialite(specialite);
                usersCVSend.setNiveauEtude(nivEtude);
                usersCVSend.setExperienceProfessionnelle(expProf);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ipAddress.getIp())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<UsersCVSend> call = api.save(usersCVSend);
                call.enqueue(new Callback<UsersCVSend>() {
                    @Override
                    public void onResponse(Call<UsersCVSend> call, Response<UsersCVSend> response) {
                        if (response.isSuccessful()) {
                            // Envoi réussi
                            Toast.makeText(RegistryActivity.this, "Votre envoi a été un succès!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistryActivity.this, VisualisationActivity.class);
                            startActivity(intent);
                        } else {
                            // Envoi échoué
                            if (response.code() == 500) {
                                // La donnée existe déjà dans la base de données
                                Toast.makeText(RegistryActivity.this, "Le mail ou le numéro de telephone Existe déjà!!", Toast.LENGTH_SHORT).show();
                            } else {
                                // Autre erreur lors de l'envoi
                                Toast.makeText(RegistryActivity.this, "Erreur lors de l'envoi. Veuillez réessayer!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<UsersCVSend> call, Throwable t) {
                        // Erreur lors de l'envoi de la requête
                        Toast.makeText(RegistryActivity.this, "Désolé, le serveur est momentanément indisponible!!", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
    }
}