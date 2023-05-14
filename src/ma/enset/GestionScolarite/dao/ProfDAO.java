package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Prof;

import java.sql.SQLException;
import java.util.List;

public interface ProfDAO extends DAO<Prof> {
    List<Prof> findAall() throws SQLException;
    Prof findOne(int id) throws SQLException;
    Prof save(Prof etudiant) throws SQLException;
    Boolean delete(Prof etudiant) throws SQLException;
    Prof update(Prof etudiant) throws SQLException;
}
