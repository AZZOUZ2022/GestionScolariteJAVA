package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.ElementDeModule;

import java.sql.SQLException;
import java.util.List;

public interface ElementDeModuleService {
    List<ElementDeModule> getAllEdms() throws SQLException;
    ElementDeModule getByNom(String Nom) throws SQLException;
    ElementDeModule getOne(int id) throws SQLException;
}
