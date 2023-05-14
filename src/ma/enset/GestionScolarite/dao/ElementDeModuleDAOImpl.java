package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.ElementDeModule;
import ma.enset.GestionScolarite.dao.entites.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ElementDeModuleDAOImpl implements ElementDeModuleDAO {
    @Override
    public List<ElementDeModule> findAall() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from edm");
        List<ElementDeModule> elementDeModules = new ArrayList<>();
        while (rs.next()) {
            ElementDeModule elementDeModule = new ElementDeModule();
            elementDeModule.setId(rs.getInt("Id"));
            elementDeModule.setNom(rs.getString("Nom"));
            elementDeModules.add(elementDeModule);
        }
        return elementDeModules;
    }

    @Override
    public ElementDeModule findByNom(String Nom) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from edm where Nom = '" + Nom + "'");
        ElementDeModule elementDeModule = new ElementDeModule();
        while (rs.next()) {
            elementDeModule.setId(rs.getInt("Id"));
            elementDeModule.setNom(rs.getString("Nom"));
        }
        return elementDeModule;
    }

    @Override
    public ElementDeModule findOne(int id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from edm where id = " + id);
        ElementDeModule elementDeModule = new ElementDeModule();
        while (rs.next()) {
            elementDeModule.setId(rs.getInt("Id"));
            elementDeModule.setNom(rs.getString("Nom"));
        }
        return elementDeModule;
    }

    @Override
    public ElementDeModule save(ElementDeModule o) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(ElementDeModule o) throws SQLException {
        return null;
    }

    @Override
    public ElementDeModule update(ElementDeModule o) throws SQLException {
        return null;
    }
}
