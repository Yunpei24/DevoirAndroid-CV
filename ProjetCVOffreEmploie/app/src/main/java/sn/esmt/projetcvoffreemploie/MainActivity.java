package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button viewCvBt;
    private Button offreBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewCvBt = (Button) findViewById(R.id.viewCvButton);
        offreBt = (Button) findViewById(R.id.offreButton);

        viewCvBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AccessListCVActivity.class);
                startActivity(intent);
            }
        });

        offreBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategorieOffreActivity.class);
                startActivity(intent);
            }
        });

    }
}