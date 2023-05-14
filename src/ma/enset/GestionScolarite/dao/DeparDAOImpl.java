package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeparDAOImpl implements DeparDAO{
    @Override
    public List<Departement> findAll() {
        Connection connection=ConnectionDB.getConnection();
        List<Departement> departements=new ArrayList<>();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from DEPARTEMENT");
            ResultSet rs=stm.executeQuery();

            while (rs.next()){
                Departement d=new Departement();
                d.setId(rs.getInt("ID"));
                d.setNom(rs.getString("NOM"));
                d.setDescription(rs.getString("DESCRIPTION"));
                departements.add(d);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return departements;
    }

    @Override
    public List<Departement> findAall() throws SQLException {
        return null;
    }

    @Override
    public Departement findOne(int id) {
        Connection connection=ConnectionDB.getConnection();
        Departement d=new Departement();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from DEPARTEMENT where ID=?");
            stm.setInt(1,id);
            ResultSet rs=stm.executeQuery();

            if(rs.next()){
                d.setId(rs.getInt("ID"));
                d.setNom(rs.getString("NOM"));
                d.setDescription(rs.getString("DEPARTEMENT"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return d;
    }

    @Override
    public Departement save(Departement o) {
        Connection connection=ConnectionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("insert into DEPARTEMENT(NOM,DESCRIPTION) values(?,?)");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getDescription());

            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return o;
    }

    @Override
    public Boolean delete(Departement o) {
        try{
            Connection connection=ConnectionDB.getConnection();
            PreparedStatement pstm=connection.prepareStatement("delete from DEPARTEMENT where ID=?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false ;
        }
        return true ;
    }

    @Override
    public Departement update(Departement o) {
        Connection connection=ConnectionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("update DEPARTEMENT set NOM=?,DESCRIPTION=? where ID=?");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getDescription());
            pstm.setInt(3,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return o;
    }
}
