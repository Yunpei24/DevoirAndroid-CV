package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.projetcvoffreemploie.httpconfig.Api;
import sn.esmt.projetcvoffreemploie.httpconfig.UsersCVResponse;
import sn.esmt.projetcvoffreemploie.ipconfig.Ip;
import sn.esmt.projetcvoffreemploie.tools.MyAdapterUserCV;

public class VisualisationActivity extends AppCompatActivity {
    private ListView list;
    private Button acceuilBt;
    private ArrayList<UsersCVResponse> userscv = new ArrayList<UsersCVResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualisation);
        list = (ListView) findViewById(R.id.listUsercv);
        acceuilBt = (Button) findViewById(R.id.accueilButton);
        chargerListeCv();

        acceuilBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VisualisationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void chargerListeCv() {
        Ip ipAddresse = new Ip();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ipAddresse.getIp()) //URL de base de l'API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<UsersCVResponse>> call = api.all();

        call.enqueue(new Callback<ArrayList<UsersCVResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UsersCVResponse>> call, Response<ArrayList<UsersCVResponse>> response) {
                if(response.isSuccessful())
                {
                    Log.d("Response :", response.body().get(0).getEmail());
                    response.body().stream().forEach(usersCVResponse -> userscv.add(usersCVResponse));
                    MyAdapterUserCV adpt = new MyAdapterUserCV(VisualisationActivity.this, userscv);
                    list.setAdapter(adpt);
                }else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<UsersCVResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.1.17 not permitted by network security policy
            }
        });
    }
}