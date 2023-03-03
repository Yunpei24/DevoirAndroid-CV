package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OffresEmploieActivity extends ListActivity {

    TextView selection;
    String[] lesOffres = {"Business Developper H/F", "Responsable Animation des Ventes", "Sales Manager Senegal",
    "Commercial B2B", "Délégué Commercial at Orange", "Sales Manager at Free", "Chef de Secteur", "Business development & sales",
    "Développeur full-stack", "Développeur(se) React", "Développeur Big Data", "Développeur BI Junior", "Ingénieur iOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offres_emploie);

        setListAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, lesOffres));
        selection = (TextView) findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v, int position, long id){
        Intent intent = new Intent(OffresEmploieActivity.this, RegistryActivity.class);
        startActivity(intent);
    }
}