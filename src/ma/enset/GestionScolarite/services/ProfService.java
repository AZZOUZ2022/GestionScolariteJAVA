package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.Note;
import ma.enset.GestionScolarite.dao.entites.Prof;

import java.sql.SQLException;
import java.util.List;

public interface ProfService {
    List<Prof> getAllProfs() throws SQLException;
    void addProf(Prof prof) throws SQLException;
    void deleteProf(Prof prof) throws SQLException;
    void modifyProf(Prof prof) throws SQLException;
}
