package ma.enset.GestionScolarite.presentations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ma.enset.GestionScolarite.dao.entites.ElementDeModule;
import ma.enset.GestionScolarite.dao.entites.Etudiant;
import ma.enset.GestionScolarite.dao.entites.Note;
import ma.enset.GestionScolarite.dao.entites.Type;
import ma.enset.GestionScolarite.services.ElementDeModuleServiceImpl;
import ma.enset.GestionScolarite.services.EtudiantServiceImpl;
import ma.enset.GestionScolarite.services.NoteServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NotesController implements Initializable {
    NoteServiceImpl noteServiceImpl = new NoteServiceImpl();
    ElementDeModuleServiceImpl elementDeModuleServiceImpl = new ElementDeModuleServiceImpl();
    EtudiantServiceImpl etudiantServiceImpl = new EtudiantServiceImpl();
    Note note;
    @FXML
    private ComboBox<String> Etudiants, EDM, type;
    @FXML
    private TextField n0te;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (ElementDeModule edm : elementDeModuleServiceImpl.getAllEdms()) {
                EDM.getItems().add(edm.getNom());
            }
            for (Etudiant etudiant : etudiantServiceImpl.getAllEtudiants()) {
                Etudiants.getItems().add(etudiant.getCNE());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        type.getItems().add("Controle");
        type.getItems().add("Examen");
        type.getItems().add("Autre");
    }
    public void Ajouter(ActionEvent ae) throws SQLException {
        note = new Note();
        note.setIdE(etudiantServiceImpl.getByCNE(Etudiants.getValue()).getId());
        if (type.getValue().toString() == "Examen")
            note.setType(Type.Examen);
        if (type.getValue().toString() == "Controle")
            note.setType(Type.Controle);
        if (type.getValue().toString() == "Autre")
            note.setType(Type.Autre);
        note.setNote(Float.parseFloat(n0te.getText()));
        note.setIdEDM(elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId());
        noteServiceImpl.addNote(note);
    }
    public void Supprimer(ActionEvent ae) throws SQLException {
        String type_ = null;
        if (type.getValue() == "Examen")
            type_ = "Examen";
        if (type.getValue() == "Controle")
            type_ = "Controle";
        if (type.getValue() == "Autre")
            type_ = "Autre";
        Note n = noteServiceImpl.getNote(elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId(), etudiantServiceImpl.getByCNE(Etudiants.getValue()).getId(), type_);
        n.setNote(Float.parseFloat(n0te.getText()));
        noteServiceImpl.deleteNote(n);
    }
    public void Modifier(ActionEvent ae) throws IOException, SQLException {
        String type_ = new String();
        if (type.getValue()== "Examen")
            type_ = "Examen";
        if (type.getValue() == "Controle")
            type_ = "Controle";
        if (type.getValue() == "Autre")
            type_ = "Autre";
        Note n = noteServiceImpl.getNote(elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId(), etudiantServiceImpl.getByCNE(Etudiants.getValue()).getId(), type_);
        n.setNote(Float.parseFloat(n0te.getText()));
        noteServiceImpl.modifyNote(n);
    }
}
