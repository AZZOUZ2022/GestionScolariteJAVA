package ma.enset.GestionScolarite.dao.entites;

public class Note {
    private int Id, IdEDM, IdE;
    private Type type;
    private float Note;

    public Note() {
    }

    public Note(int id, int idEDM, int idE, Type type, float note) {
        Id = id;
        IdEDM = idEDM;
        IdE = idE;
        this.type = type;
        Note = note;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdEDM() {
        return IdEDM;
    }

    public void setIdEDM(int idEDM) {
        IdEDM = idEDM;
    }

    public int getIdE() {
        return IdE;
    }

    public void setIdE(int idE) {
        IdE = idE;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getNote() {
        return Note;
    }

    public void setNote(float note) {
        Note = note;
    }
}
