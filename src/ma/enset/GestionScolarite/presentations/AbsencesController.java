package ma.enset.GestionScolarite.presentations;

import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.GestionScolarite.dao.entites.Absence;
import ma.enset.GestionScolarite.dao.entites.ElementDeModule;
import ma.enset.GestionScolarite.dao.entites.Etudiant;
import ma.enset.GestionScolarite.services.AbsenceServiceImpl;
import ma.enset.GestionScolarite.services.ElementDeModuleServiceImpl;
import ma.enset.GestionScolarite.services.EtudiantServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AbsencesController implements Initializable {
    AbsenceServiceImpl absenceServiceImpl = new AbsenceServiceImpl();
    EtudiantServiceImpl etudiantServiceImpl = new EtudiantServiceImpl();
    ElementDeModuleServiceImpl elementDeModuleServiceImpl = new ElementDeModuleServiceImpl();
    Absence absence;
    @FXML
    private TextField date, nbreHeures;
    @FXML
    private ComboBox<String> etudiants, EDM, etudiantsC, EDMC;
    @FXML
    private TableView<Absence> table;
    @FXML
    private TableColumn<Absence, String> dateT, nbreHeuresT, etudiantT, EDMT;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (ElementDeModule edm : elementDeModuleServiceImpl.getAllEdms()) {
                EDM.getItems().add(edm.getNom());
                EDMC.getItems().add(edm.getNom());
            }
            for (Etudiant etudiant : etudiantServiceImpl.getAllEtudiants()) {
                etudiants.getItems().add(etudiant.getCNE());
                etudiantsC.getItems().add(etudiant.getCNE());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ShowAll(new ActionEvent());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table.setOnMouseClicked(event -> {
            absence = table.getSelectionModel().getSelectedItem();
            if (absence != null) {
                date.setText(absence.getDate());
                nbreHeures.setText(String.valueOf(absence.getNbreHeures()));
            }
        });
    }
    public void Ajouter(ActionEvent ae) throws SQLException {
        absence = new Absence();
        absence.setNbreHeures(Integer.parseInt(nbreHeures.getText()));
        absence.setDate(date.getText());
        absence.setIdEtudiant(etudiantServiceImpl.getByCNE(etudiants.getValue()).getId());
        absence.setIdEDM(elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId());
        absenceServiceImpl.addAbs(absence);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void ShowAll(ActionEvent ae) throws SQLException {
        table.getItems().clear();
        for (Absence a : absenceServiceImpl.getAllAbs()) {
            dateT.setCellValueFactory(new PropertyValueFactory<Absence, String>("date"));
            nbreHeuresT.setCellValueFactory(new PropertyValueFactory<Absence, String>("nbreHeures"));
            etudiantT.setCellValueFactory(new PropertyValueFactory<Absence, String>("idEtudiant"));
            EDMT.setCellValueFactory(new PropertyValueFactory<Absence, String>("idEDM"));
            ObservableList<Absence> data = FXCollections.observableArrayList(a);
            table.getItems().addAll(data);
        }
    }
    public void Supprimer(ActionEvent ae) throws SQLException {
        Absence a = absenceServiceImpl.getAllAbs(etudiantServiceImpl.getByCNE(etudiants.getValue()).getId(), elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId());
        absenceServiceImpl.deleteAbs(a);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void Modifier(ActionEvent ae) throws IOException, SQLException {
        Absence a = absenceServiceImpl.getAllAbs(etudiantServiceImpl.getByCNE(etudiants.getValue()).getId(), elementDeModuleServiceImpl.getByNom(EDM.getValue()).getId());
        a.setNbreHeures(Integer.parseInt(nbreHeures.getText()));
        absenceServiceImpl.modifyAbs(a);
        table.getItems().clear();
        ShowAll(new ActionEvent());
    }
    public void Rechercher(ActionEvent ae) throws SQLException {
        table.getItems().clear();
        Etudiant e = etudiantServiceImpl.getByCNE(etudiantsC.getValue());
        ElementDeModule edm = elementDeModuleServiceImpl.getByNom(EDMC.getValue());
        for (Absence a : absenceServiceImpl.getAllAbsM(e.getId(), edm.getId())) {
            dateT.setCellValueFactory(new PropertyValueFactory<Absence, String>("date"));
            nbreHeuresT.setCellValueFactory(new PropertyValueFactory<Absence, String>("nbreHeures"));
            etudiantT.setCellValueFactory(new PropertyValueFactory<Absence, String>("idEtudiant"));
            EDMT.setCellValueFactory(new PropertyValueFactory<Absence, String>("idEDM"));
            ObservableList<Absence> data = FXCollections.observableArrayList(a);
            table.getItems().addAll(data);
        }
    }
}
