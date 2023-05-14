package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Absence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbsenceDAOimpl implements AbsenceDAO {

    @Override
    public List<Absence> findAall() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from absence");
        List<Absence> absences = new ArrayList<>();
        while (rs.next()) {
            Absence absence = new Absence();
            absence.setId(rs.getInt("id"));
            absence.setDate(rs.getString("date"));
            absence.setNbreHeures(rs.getInt("nbreHeures"));
            absence.setIdEDM(rs.getInt("idEDM"));
            absence.setIdEtudiant(rs.getInt("idEtudiant"));
            absences.add(absence);
        }
        return absences;
    }

    @Override
    public Absence findOne(int id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from absence where id = " + id);
        Absence absence = new Absence();
        while (rs.next()) {
            absence.setId(rs.getInt("id"));
            absence.setDate(rs.getString("date"));
            absence.setNbreHeures(rs.getInt("nbreHeures"));
            absence.setIdEDM(rs.getInt("idEDM"));
            absence.setIdEtudiant(rs.getInt("idEtudiant"));
        }
        return absence;
    }

    @Override
    public Absence findOne(int idE, int idEDM) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from absence where idEtudiant = " + idE + " and idEDM = " + idEDM + " limit 1");
        Absence absence = new Absence();
        while (rs.next()) {
            absence.setId(rs.getInt("id"));
            absence.setDate(rs.getString("date"));
            absence.setNbreHeures(rs.getInt("nbreHeures"));
            absence.setIdEDM(rs.getInt("idEDM"));
            absence.setIdEtudiant(rs.getInt("idEtudiant"));
        }
        return absence;
    }

    @Override
    public List<Absence> findOneMany(int idE, int idEDM) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from absence where idEtudiant = " + idE + " and idEDM = " + idEDM);
        List<Absence> absences = new ArrayList<>();
        while (rs.next()) {
            Absence absence = new Absence();
            absence.setId(rs.getInt("id"));
            absence.setDate(rs.getString("date"));
            absence.setNbreHeures(rs.getInt("nbreHeures"));
            absence.setIdEDM(rs.getInt("idEDM"));
            absence.setIdEtudiant(rs.getInt("idEtudiant"));
            absences.add(absence);
        }
        return absences;
    }

    @Override
    public Absence save(Absence absence) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("insert into absence(nbreHeures, date, idEDM, idEtudiant) values (" + absence.getNbreHeures() + ", '" + absence.getDate() + "', " + absence.getIdEDM() +", "+ absence.getIdEtudiant() +")");
        return absence;
    }

    @Override
    public Boolean delete(Absence absence) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        int state = stm.executeUpdate("delete from absence where id = " + absence.getId());
        if (state == 1)
            return true;
        else
            return false;
    }

    @Override
    public Absence update(Absence absence) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        stm.executeUpdate("update absence set  nbreHeures = " + absence.getNbreHeures() + " where id = " + absence.getId());
        ResultSet rs = stm.executeQuery("select * from absence where id = " + absence.getId());
        Absence a = new Absence();
        while (rs.next()) {
            a.setId(rs.getInt("id"));
            a.setDate(rs.getString("date"));
            a.setNbreHeures(rs.getInt("nbreHeures"));
            a.setIdEDM(rs.getInt("idEDM"));
            a.setIdEtudiant(rs.getInt("idEtudiant"));
        }
        return a;
    }
}

