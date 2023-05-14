package ma.enset.GestionScolarite.presentations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.GestionScolarite.dao.DeparDAOImpl;
import ma.enset.GestionScolarite.dao.FiliereDAOImpl;
import ma.enset.GestionScolarite.dao.entites.Departement;
import ma.enset.GestionScolarite.services.ReservationService;
import ma.enset.GestionScolarite.services.ReservationServiseImpl;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textDescription;


    @FXML
    private TableView<Departement> departementView ;
    @FXML
    private TableColumn<Departement,Integer> colID ;
    @FXML
    private TableColumn<Departement,String> colNom ;
    @FXML
    private TableColumn<Departement,String> colDescription;



    ObservableList<Departement> observableList= FXCollections.observableArrayList();
    ReservationService reservationService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reservationService=new ReservationServiseImpl(new FiliereDAOImpl(),new DeparDAOImpl());
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        departementView.setItems(observableList);
        try {
            loaderDepartement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void addDepartement() throws SQLException {
        String nom= textNom.getText();
        String description=textDescription.getText();
        Departement d=new Departement();
        d.setNom(nom);
        d.setDescription(description);
        if(nom.isEmpty() ){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("remplir tous les info de departement");
            alert.show();
        }else {
        reservationService.addDepartement(d);
        loaderDepartement();
        textNom.setText("");
        textDescription.setText("");
       }

    }
    @FXML
    public void delDepartement() throws SQLException {
        Departement d=departementView.getSelectionModel().getSelectedItem();
        if(d==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("veuillez selectinner une département");
            alert.show();
        }else {
        reservationService.delDepartement(d);
        loaderDepartement();}
    }

    private void loaderDepartement() throws SQLException {
        observableList.clear();
        observableList.addAll(reservationService.getAllDepartement());
    }
}
