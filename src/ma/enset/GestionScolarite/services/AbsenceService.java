package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.Absence;

import java.sql.SQLException;
import java.util.List;

public interface AbsenceService {
    List<Absence> getAllAbs() throws SQLException;
    Absence getAllAbs(int idE, int idEDM) throws SQLException;
    List<Absence> getAllAbsM(int idE, int idEDM) throws SQLException;
    Absence getOne(String nom);
    void addAbs(Absence absence) throws SQLException;
    void deleteAbs(Absence absence) throws SQLException;
    void modifyAbs(Absence absence) throws SQLException;
}
