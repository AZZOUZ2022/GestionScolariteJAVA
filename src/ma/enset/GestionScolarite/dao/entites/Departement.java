package ma.enset.GestionScolarite.dao.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Departement implements Serializable {
    private int id ;
    private String nom ;
    private String description ;

    private List<Filiere> filieres=new ArrayList<>();


    public Departement() {
    }

    public Departement(String nom, String description, List<Filiere> filieres) {
        this.nom = nom;
        this.description = description;
        this.filieres = filieres;
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

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
