package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.Departement;
import ma.enset.GestionScolarite.dao.entites.Filiere;


import java.sql.SQLException;
import java.util.List;

public interface ReservationService {
    List<Filiere> getAllFilieres() throws SQLException;
    void addFiliere(Filiere p) throws SQLException;
    void deleteFiliere(Filiere p) throws SQLException;
    List<Filiere> getFiliereParMc(String mc);

    List<Departement> getAllDepartement() throws SQLException;
    Departement getDepartementById(int id) throws SQLException;
    void addDepartement(Departement c) throws SQLException;
    void delDepartement(Departement c) throws SQLException;
}
