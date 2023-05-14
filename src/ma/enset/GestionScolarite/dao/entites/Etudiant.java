package ma.enset.GestionScolarite.dao.entites;

public class Etudiant {
    private int Id;
    private String Nom, Prenom, Email, Password, CNE;

    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, String email, String password, String CNE) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Email = email;
        Password = password;
        this.CNE = CNE;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }
}
