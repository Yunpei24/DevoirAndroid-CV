package sn.esmt.emploie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "appuserscv")
public class AppUserCVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100,nullable = false)
    private String prenom;
    @Column(length = 100,nullable = false)
    private String nom;
    @Column(length = 50, nullable = false)
    private int age;

    @Column(length = 200, nullable = false, unique = true)
    private String email;
    @Column(length = 200,nullable = false)
    private String adresse;
    @Column(length = 200,nullable = false, unique = true)
    private String telephone;
    @Column(length = 300,nullable = false)
    private String specialite;
    @Column(length = 100,nullable = false)
    private String niveauEtude;
    @Column(length = 500,nullable = false)
    private String experienceProfessionnelle;

}
