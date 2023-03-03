package sn.esmt.projetcvoffreemploie.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sn.esmt.projetcvoffreemploie.R;
import sn.esmt.projetcvoffreemploie.httpconfig.UsersCVResponse;

public class MyAdapterUserCV extends BaseAdapter {
    private ArrayList<UsersCVResponse> userscv;
    private LayoutInflater myInflater;

    public MyAdapterUserCV(Context context, ArrayList<UsersCVResponse> userscv){
        this.myInflater = LayoutInflater.from(context);
        this.userscv = userscv;
    }

    @Override
    public int getCount() {
        return this.userscv.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.userscv.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textemail;
        TextView texttelephone;
        TextView textprenom;
        TextView textnom;
        TextView textage;
        TextView textspecialite;
        TextView textexperienceprofessionnelle;
        TextView textadresse;
        TextView textniveauetude;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = myInflater.inflate(R.layout.listitem_usercv, null);
            holder = new ViewHolder();
            holder.textnom = (TextView) convertView.findViewById(R.id.txtnom);
            holder.textprenom = (TextView) convertView.findViewById(R.id.txtprenom);
            holder.textage = (TextView) convertView.findViewById(R.id.txtage);
            holder.textemail = (TextView) convertView.findViewById(R.id.txtemail);
            holder.texttelephone = (TextView) convertView.findViewById(R.id.txttelephone);
            holder.textadresse = (TextView) convertView.findViewById(R.id.txtadresse);
            holder.textniveauetude = (TextView) convertView.findViewById(R.id.txtniveauetude);
            holder.textspecialite = (TextView) convertView.findViewById(R.id.txtspecialite);
            holder.textexperienceprofessionnelle = (TextView) convertView.findViewById(R.id.txtexperienceprofessionnelle);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String nomstr = "Nom : "+userscv.get(position).getNom();
        String prenomstr = "Prénom(s) : "+userscv.get(position).getPrenom();
        String agestr = "Age : "+userscv.get(position).getAge()+" ans";
        String emailstr = "Email : "+userscv.get(position).getEmail();
        String telephonestr = "Téléphone : "+userscv.get(position).getTelephone();
        String adressestr = "Adresse : "+userscv.get(position).getAdresse();
        String niveauetudestr = "Niveau d'Etude : "+userscv.get(position).getNiveauEtude();
        String specialstr = "Spécialité : "+userscv.get(position).getSpecialite();
        String expProfstr = "Expérience Professionnelle : "+userscv.get(position).getExperienceProfessionnelle();

        holder.textnom.setText(nomstr);
        holder.textprenom.setText(prenomstr);
        holder.textage.setText(agestr);
        holder.textemail.setText(emailstr);
        holder.texttelephone.setText(telephonestr);
        holder.textadresse.setText(adressestr);
        holder.textniveauetude.setText(niveauetudestr);
        holder.textspecialite.setText(specialstr);
        holder.textexperienceprofessionnelle.setText(expProfstr);

        return convertView;
    }
}
