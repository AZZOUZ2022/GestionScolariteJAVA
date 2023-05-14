package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfDAOImpl implements ProfDAO {
    @Override
    public List<Prof> findAall() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from professeur");
        List<Prof> profs = new ArrayList<>();
        while (rs.next()) {
            Prof prof = new Prof();
            prof.setId(rs.getInt("Id"));
            prof.setNom(rs.getString("Nom"));
            prof.setPrenom(rs.getString("Prenom"));
            prof.setEmail(rs.getString("Email"));
            prof.setPassword(rs.getString("Password"));
            prof.setMatricule(rs.getString("Matricule"));
            profs.add(prof);
        }
        return profs;
    }

    @Override
    public Prof findOne(int id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from professeur where id = " + id);
        Prof prof = new Prof();
        while (rs.next()) {
            prof.setId(rs.getInt("Id"));
            prof.setNom(rs.getString("Nom"));
            prof.setPrenom(rs.getString("Prenom"));
            prof.setEmail(rs.getString("Email"));
            prof.setPassword(rs.getString("Password"));
            prof.setMatricule(rs.getString("Matricule"));
        }
        return prof;
    }

    @Override
    public Prof save(Prof prof) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("insert into professeur(Nom, Prenom, Email, Password, Matricule) values ('" + prof.getNom() + "', '" + prof.getPrenom() + "', '" + prof.getEmail() +"', '"+ prof.getPassword() +"', '"+ prof.getMatricule() +"')");
        return prof;
    }

    @Override
    public Boolean delete(Prof prof) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        int state = stm.executeUpdate("delete from professeur where Id = " + prof.getId());
        if (state == 1)
            return true;
        else
            return false;
    }

    @Override
    public Prof update(Prof prof) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("update etudiant set  Nom = '" + prof.getNom() + "', Prenom = '" + prof.getPrenom() + "', Email = '" + prof.getEmail() + "', Password = '" + prof.getPassword() + "', CNE = '" + prof.getMatricule() +"' where Id = " + prof.getId());
        ResultSet rs = stm.executeQuery("select * from professeur where Id = " + prof.getId());
        Prof p = new Prof();
        while (rs.next()) {
            p.setId(rs.getInt("Id"));
            p.setNom(rs.getString("Nom"));
            p.setPrenom(rs.getString("Prenom"));
            p.setEmail(rs.getString("Email"));
            p.setPassword(rs.getString("Password"));
            p.setMatricule(rs.getString("Matricule"));
        }
        return p;
    }
}
