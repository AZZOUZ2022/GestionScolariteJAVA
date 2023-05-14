package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Etudiant;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantDAO extends DAO<Etudiant> {
    List<Etudiant> findAall() throws SQLException;
    Etudiant findOne(int id) throws SQLException;
    Etudiant findOneByName(String Nom, String Prenom) throws SQLException;
    Etudiant findOneCNE(String CNE) throws SQLException;
    Etudiant save(Etudiant etudiant) throws SQLException;
    Boolean delete(Etudiant etudiant) throws SQLException;
    Etudiant update(Etudiant etudiant) throws SQLException;
}
