package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAOImpl implements EtudiantDAO {
    @Override
    public List<Etudiant> findAall() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from etudiant");
        List<Etudiant> etudiants = new ArrayList<>();
        while (rs.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(rs.getInt("Id"));
            etudiant.setNom(rs.getString("Nom"));
            etudiant.setPrenom(rs.getString("Prenom"));
            etudiant.setEmail(rs.getString("Email"));
            etudiant.setPassword(rs.getString("Password"));
            etudiant.setCNE(rs.getString("CNE"));
            etudiants.add(etudiant);
        }
        return etudiants;
    }

    @Override
    public Etudiant findOne(int id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from etudiant where id = " + id);
        Etudiant etudiant = new Etudiant();
        while (rs.next()) {
            etudiant.setId(rs.getInt("Id"));
            etudiant.setNom(rs.getString("Nom"));
            etudiant.setPrenom(rs.getString("Prenom"));
            etudiant.setEmail(rs.getString("Email"));
            etudiant.setPassword(rs.getString("Password"));
            etudiant.setCNE(rs.getString("CNE"));
        }
        return etudiant;
    }

    @Override
    public Etudiant findOneByName(String Nom, String Prenom) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from etudiant where Nom = '" + Nom + "' and Prenom = '" + Prenom + "'");
        Etudiant etudiant = new Etudiant();
        while (rs.next()) {
            etudiant.setId(rs.getInt("Id"));
            etudiant.setNom(rs.getString("Nom"));
            etudiant.setPrenom(rs.getString("Prenom"));
            etudiant.setEmail(rs.getString("Email"));
            etudiant.setPassword(rs.getString("Password"));
            etudiant.setCNE(rs.getString("CNE"));
        }
        return etudiant;
    }

    @Override
    public Etudiant findOneCNE(String CNE) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from etudiant where CNE = '" + CNE + "'");
        Etudiant etudiant = new Etudiant();
        while (rs.next()) {
            etudiant.setId(rs.getInt("Id"));
            etudiant.setNom(rs.getString("Nom"));
            etudiant.setPrenom(rs.getString("Prenom"));
            etudiant.setEmail(rs.getString("Email"));
            etudiant.setPassword(rs.getString("Password"));
            etudiant.setCNE(rs.getString("CNE"));
        }
        return etudiant;
    }

    @Override
    public Etudiant save(Etudiant etudiant) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("insert into etudiant(Nom, Prenom, Email, Password, CNE) values ('" + etudiant.getNom() + "', '" + etudiant.getPrenom() + "', '" + etudiant.getEmail() +"', '"+ etudiant.getPassword() +"', '"+ etudiant.getCNE() +"')");
        return etudiant;
    }

    @Override
    public Boolean delete(Etudiant etudiant) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        int state = stm.executeUpdate("delete from etudiant where Id = " + etudiant.getId());
        if (state == 1)
            return true;
        else
            return false;
    }

    @Override
    public Etudiant update(Etudiant etudiant) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("update etudiant set  Nom = '" + etudiant.getNom() + "', Prenom = '" + etudiant.getPrenom() + "', Email = '" + etudiant.getEmail() + "', Password = '" + etudiant.getPassword() + "', CNE = '" + etudiant.getCNE() +"' where Id = " + etudiant.getId());
        ResultSet rs = stm.executeQuery("select * from etudiant where Id = " + etudiant.getId());
        Etudiant e = new Etudiant();
        while (rs.next()) {
            e.setId(rs.getInt("Id"));
            e.setNom(rs.getString("Nom"));
            e.setPrenom(rs.getString("Prenom"));
            e.setEmail(rs.getString("Email"));
            e.setPassword(rs.getString("Password"));
            e.setCNE(rs.getString("CNE"));
        }
        return etudiant;
    }
}
