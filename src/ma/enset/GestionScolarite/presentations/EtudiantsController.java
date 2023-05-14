package ma.enset.GestionScolarite.presentations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.GestionScolarite.dao.entites.Etudiant;
import ma.enset.GestionScolarite.services.EtudiantServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EtudiantsController implements Initializable {
    EtudiantServiceImpl etudiantServiceImpl = new EtudiantServiceImpl();
    Etudiant etudiant;
    @FXML
    private TextField Nom, Prenom, Email, CNE, Password, x;
    @FXML
    private TableView<Etudiant> table;
    @FXML
    private TableColumn<Etudiant, String> NomT, PrenomT, CNET, PasswordT, EmailT;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ShowAll(new ActionEvent());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setOnMouseClicked(event -> {
            Etudiant etudiant = table.getSelectionModel().getSelectedItem();
            if (etudiant != null) {
                Nom.setText(etudiant.getNom());
                Prenom.setText(etudiant.getPrenom());
                CNE.setText(etudiant.getCNE());
                Email.setText(etudiant.getEmail());
                Password.setText(etudiant.getPassword());
            }
        });
    }
    public void Ajouter(ActionEvent ae) throws SQLException {
        etudiant = new Etudiant();
        etudiant.setNom(Nom.getText());
        etudiant.setPrenom(Prenom.getText());
        etudiant.setCNE(CNE.getText());
        etudiant.setEmail(Email.getText());
        etudiant.setPassword(Password.getText());
        etudiantServiceImpl.addEtudiant(etudiant);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void ShowAll(ActionEvent ae) throws SQLException {
        table.getItems().clear();
        for (Etudiant e : etudiantServiceImpl.getAllEtudiants()) {
            NomT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Nom"));
            PrenomT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Prenom"));
            EmailT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Email"));
            CNET.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("CNE"));
            PasswordT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Password"));
            ObservableList<Etudiant> data = FXCollections.observableArrayList(e);
            table.getItems().addAll(data);
        }
    }
    public void Supprimer(ActionEvent ae) throws SQLException {
        Etudiant e = etudiantServiceImpl.getByName(Nom.getText(), Prenom.getText());
        etudiantServiceImpl.deleteEtudiant(e);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void Modifier(ActionEvent ae) throws IOException, SQLException {
        Etudiant e = etudiantServiceImpl.getByName(Nom.getText(), Prenom.getText());
        e.setNom(Nom.getText());
        e.setPrenom(Prenom.getText());
        e.setCNE(CNE.getText());
        e.setEmail(Email.getText());
        e.setPassword(Password.getText());
        etudiantServiceImpl.modifyEtudiant(e);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void Rechercher(ActionEvent ae) throws SQLException {
        table.getItems().clear();
        Etudiant e;
        e = etudiantServiceImpl.getByCNE(x.getText());
        NomT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Nom"));
        PrenomT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Prenom"));
        EmailT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Email"));
        CNET.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("CNE"));
        PasswordT.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Password"));
        ObservableList<Etudiant> data = FXCollections.observableArrayList(e);
        table.getItems().addAll(data);
    }
}
