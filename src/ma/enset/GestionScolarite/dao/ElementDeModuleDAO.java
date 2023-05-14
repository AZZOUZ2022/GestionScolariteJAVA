package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.ElementDeModule;

import java.sql.SQLException;
import java.util.List;

public interface ElementDeModuleDAO extends DAO<ElementDeModule> {
    List<ElementDeModule> findAall() throws SQLException;
    ElementDeModule findByNom(String Nom) throws SQLException;
}
