package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class OffresEmploieActivity extends ListActivity {

    TextView selection;
    private Button retourCatBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offres_emploie);

        retourCatBt = (Button) findViewById(R.id.retourCatButton);

        retourCatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String[] offreDevops = getIntent().getStringArrayExtra("offresDevops");
        String idDeops = getIntent().getStringExtra("idDevops");

        String[] offreIA = getIntent().getStringArrayExtra("offresIA");
        String idIA = getIntent().getStringExtra("idIA");

        String[] offreMarketing = getIntent().getStringArrayExtra("offresMarketing");
        String idMarketing = getIntent().getStringExtra("idMarketing");

        String[] offreFinance = getIntent().getStringArrayExtra("offresFinance");
        String idFinance = getIntent().getStringExtra("idFinance");

        String[] offreEdu = getIntent().getStringArrayExtra("offresEdu");
        String idEdu = getIntent().getStringExtra("idEdu");

        String[] offreTelecom = getIntent().getStringArrayExtra("offresTelecom");
        String idTelecom = getIntent().getStringExtra("idTelecom");

        if("Devops".equals(idDeops)){
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreDevops));
            selection = (TextView) findViewById(R.id.selection);
        } else if ("ia".equals(idIA)) {
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreIA));
            selection = (TextView) findViewById(R.id.selection);
        } else if ("marketing".equals(idMarketing)) {
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreMarketing));
            selection = (TextView) findViewById(R.id.selection);
        } else if ("finance".equals(idFinance)) {
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreFinance));
            selection = (TextView) findViewById(R.id.selection);
        } else if ("edu".equals(idEdu)) {
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreEdu));
            selection = (TextView) findViewById(R.id.selection);
        } else if ("telecom".equals(idTelecom)) {
            setListAdapter(new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, offreTelecom));
            selection = (TextView) findViewById(R.id.selection);
        }

    }

    public void onListItemClick(ListView parent, View v, int position, long id){
        Intent intent = new Intent(OffresEmploieActivity.this, RegistryActivity.class);
        startActivity(intent);
    }
}