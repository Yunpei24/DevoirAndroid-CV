package sn.esmt.projetcvoffreemploie.httpconfig;

public class UsersCVResponse {

    private String prenom;

    private String nom;

    private String email;

    private String adresse;
    private String telephone;
    private String specialite;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public void setExperienceProfessionnelle(String experienceProfessionnelle) {
        this.experienceProfessionnelle = experienceProfessionnelle;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public String getExperienceProfessionnelle() {
        return experienceProfessionnelle;
    }

    private int age;
    private String niveauEtude;
    private String experienceProfessionnelle;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UsersCVResponse(String prenom, String nom, String email, String adresse, String telephone, String specialite, int age, String niveauEtude, String experienceProfessionnelle) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.specialite = specialite;
        this.age = age;
        this.niveauEtude = niveauEtude;
        this.experienceProfessionnelle = experienceProfessionnelle;
    }

    public UsersCVResponse() {
    }
}
