package ma.enset.GestionScolarite.presentations;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.GestionScolarite.dao.DeparDAOImpl;
import ma.enset.GestionScolarite.dao.FiliereDAOImpl;
import ma.enset.GestionScolarite.dao.entites.Departement;
import ma.enset.GestionScolarite.dao.entites.Filiere;
import ma.enset.GestionScolarite.services.ReservationService;
import ma.enset.GestionScolarite.services.ReservationServiseImpl;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FiliereController implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textDescription;

    @FXML
    private TextField textPrerequis;

    @FXML
    private ComboBox<Departement> deparCombobox;
    @FXML
    private TableView<Filiere> tableView;
    @FXML
    private TableColumn<Filiere, Integer> colID;
    @FXML
    private TableColumn<Filiere, String> colNom;
    @FXML
    private TableColumn<Filiere, Float> colDescription;
    @FXML
    private TableColumn<Filiere, Float> colPrerequis;
    @FXML
    private TableColumn<Filiere, Departement> coldepartement;

    private ObservableList<Filiere> observableList = FXCollections.observableArrayList();
    private ReservationService reservationService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reservationService = new ReservationServiseImpl(new FiliereDAOImpl(), new DeparDAOImpl());
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrerequis.setCellValueFactory(new PropertyValueFactory<>("prerequis"));
        try {
            deparCombobox.getItems().addAll(reservationService.getAllDepartement());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableView.setItems(observableList);
        try {
            loaderFiliere();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void addFiliere() throws SQLException {
        String nom=textNom.getText();
        String description=textDescription.getText();
        String prerequis=textPrerequis.getText();

        Departement departement=deparCombobox.getSelectionModel().getSelectedItem();
        if(nom.isEmpty() ){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("saisir tous les champs");
            alert.show();
        }else {
            Filiere f = new Filiere();
            f.setNom(nom);
            f.setDescription(description);
            f.setPrerequis(prerequis);
            f.setDepartement(departement);
            reservationService.addFiliere(f);
            loaderFiliere();
        }}
    @FXML
    public void delFiliere() throws SQLException {
        Filiere filiere=tableView.getSelectionModel().getSelectedItem();
        if(filiere==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("veuillez selectinner une filiere");
            alert.show();
        }else {
            reservationService.deleteFiliere(filiere);
            loaderFiliere();}
    }
    public void loaderFiliere() throws SQLException {
        observableList.clear();
        observableList.addAll(reservationService.getAllFilieres());
    }
}
