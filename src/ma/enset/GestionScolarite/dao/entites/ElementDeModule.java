package ma.enset.GestionScolarite.dao.entites;

public class ElementDeModule {
    private int id;
    private String Nom;

    public ElementDeModule() {
    }

    public ElementDeModule(int id, String nom) {
        this.id = id;
        Nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
