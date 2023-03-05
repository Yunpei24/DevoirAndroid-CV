package sn.esmt.projetcvoffreemploie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategorieOffreActivity extends AppCompatActivity {

    private CardView devopCrd;
    private CardView iaCrd;
    private CardView marketingCrd;
    private CardView financeCrd;
    private CardView eduCrd;
    private CardView telecomCrd;
    private String[] lesOffresDev = {"Développeur full-stack", "Développeur(se) React", "Ingénieur iOS", "Développeur JAVA",
            "Développeu·r·se Frontend (React / React Native)", "Développeur Web Confirmé"};
    private  String[] lesOffresIA = {"Développeur Big Data", "Développeur BI Junior", "Ingénieur specialiste en NLP"};
    String[] lesOffresMarketing = {"Business Developper H/F", "Responsable Animation des Ventes", "Sales Manager Senegal",
            "Commercial B2B", "Délégué Commercial à Orange", "Sales Manager at Free", "Chef de Secteur", "Business development & sales"};
    String[] lesOffresFinance = {"Assistant administratif et\n financier Europe H/F (H/F)", "Contrôleur Financier et \nComptable","Responsable Administratif et \nfinancier à Orange",
            "Expert finance et \ncomptabilité", "Conseiller financier \nde banque (F/H)", "Gestionnaire back-office \nfinance de marché"};
    String[] lesOffresEdu = {"Professeur en Java à ESMT", "Responsable pédagogique à UTS", "Maitre assistant en maths à l'UCAD"};
    String[] lesOffresTelecom = {"Ingénieur commutation", "Ingénieur coeur réseau", "Ingénieur Telecom spécialité 5G à Free",
            "Responsable Departement Telecom à ONATEL", "Ingénieur deploiement fibre optique"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_offre);

        devopCrd = (CardView) findViewById(R.id.devops);
        iaCrd = (CardView) findViewById(R.id.ia);
        marketingCrd = (CardView) findViewById(R.id.marketing);
        financeCrd = (CardView) findViewById(R.id.finance);
        eduCrd = (CardView) findViewById(R.id.edu);
        telecomCrd = (CardView) findViewById(R.id.telecom);

        devopCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "Devops";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresDevops", lesOffresDev);
                intent.putExtra("idDevops", cardId);
                startActivity(intent);
            }
        });
        iaCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "ia";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresIA", lesOffresIA);
                intent.putExtra("idIA", cardId);
                startActivity(intent);
            }
        });
        marketingCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "marketing";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresMarketing", lesOffresMarketing);
                intent.putExtra("idMarketing", cardId);
                startActivity(intent);
            }
        });
        financeCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "finance";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresFinance", lesOffresFinance);
                intent.putExtra("idFinance", cardId);
                startActivity(intent);
            }
        });
        eduCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "edu";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresEdu", lesOffresEdu);
                intent.putExtra("idEdu", cardId);
                startActivity(intent);
            }
        });
        telecomCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardId = "telecom";
                Intent intent = new Intent(CategorieOffreActivity.this, OffresEmploieActivity.class);
                intent.putExtra("offresTelecom", lesOffresTelecom);
                intent.putExtra("idTelecom", cardId);
                startActivity(intent);
            }
        });
    }
}