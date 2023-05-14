package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.ElementDeModuleDAOImpl;
import ma.enset.GestionScolarite.dao.entites.ElementDeModule;

import java.sql.SQLException;
import java.util.List;

public class ElementDeModuleServiceImpl implements ElementDeModuleService {
    ElementDeModuleDAOImpl elementDeModuleDAOImpl = new ElementDeModuleDAOImpl();
    @Override
    public List<ElementDeModule> getAllEdms() throws SQLException {
        return elementDeModuleDAOImpl.findAall();
    }

    @Override
    public ElementDeModule getByNom(String Nom) throws SQLException {
        return elementDeModuleDAOImpl.findByNom(Nom);
    }
    @Override
    public ElementDeModule getOne(int id) throws SQLException {
        return elementDeModuleDAOImpl.findOne(id);
    }
}
