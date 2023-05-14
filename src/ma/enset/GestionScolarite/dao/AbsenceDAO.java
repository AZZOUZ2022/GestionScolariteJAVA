package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Absence;

import java.sql.SQLException;
import java.util.List;

public interface AbsenceDAO extends DAO<Absence> {
    List<Absence> findAall() throws SQLException;
    Absence findOne(int id) throws SQLException;
    Absence findOne(int idE, int idEDM) throws SQLException;
    List<Absence> findOneMany(int idE, int idEDM) throws SQLException;
    Absence save(Absence absence) throws SQLException;
    Boolean delete(Absence absence) throws SQLException;
    Absence update(Absence absence) throws SQLException;
}
