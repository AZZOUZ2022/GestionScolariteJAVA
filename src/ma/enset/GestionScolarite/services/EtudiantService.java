package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.Etudiant;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants() throws SQLException;
    Etudiant getByName(String Nom, String Prenom) throws SQLException;
    Etudiant getOne(int id) throws SQLException;
    Etudiant getByCNE(String CNE) throws SQLException;
    void addEtudiant(Etudiant etudiant) throws SQLException;
    void deleteEtudiant(Etudiant etudiant) throws SQLException;
    void modifyEtudiant(Etudiant etudiant) throws SQLException;
}
