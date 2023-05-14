package ma.enset.GestionScolarite.dao.entites;

import java.io.Serializable;

public class Absence implements Serializable {
    private int id;
    private int idEtudiant;
    private int idEDM;
    private String date;
    private int nbreHeures;

    public Absence() {}

    public int getId() {
        return id;
    }

    public void setId(int id_abs) {
        this.id = id_abs;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdEDM() {
        return idEDM;
    }

    public void setIdEDM(int idEDM) {
        this.idEDM = idEDM;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }
}

