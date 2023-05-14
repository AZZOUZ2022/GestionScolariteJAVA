package ma.enset.GestionScolarite.dao.entites;

import java.io.Serializable;

public class Filiere implements Serializable {

    private int id ;
    private String nom;
    private String description ;
    private String prerequis ;
    private Departement departement;


    public Filiere() {
    }

    public Filiere(String nom, String description, String prerequis, Departement departement) {
        this.nom = nom;
        this.description = description;
        this.prerequis = prerequis;
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(String prerequis) {
        this.prerequis = prerequis;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
