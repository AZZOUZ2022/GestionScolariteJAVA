package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Departement;
import ma.enset.GestionScolarite.dao.entites.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereDAOImpl implements FiliereDAO {
    @Override
    public List<Filiere> findAll() {
        Connection connection=ConnectionDB.getConnection();
        List<Filiere> filieres=new ArrayList<>();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from FILIERE f , DEPARTEMENT d where f.ID_DEPARTEMENT=d.ID");
            ResultSet rs=stm.executeQuery();

            while (rs.next()){
                Filiere f=new Filiere();
                f.setId(rs.getInt("ID"));
                f.setNom(rs.getString("NOM"));
                f.setDescription(rs.getString("DESCRIPTION"));
                f.setPrerequis(rs.getString("PRE_REQUIS"));
                Departement d=new Departement();
                d.setId(rs.getInt("ID_DEPARTEMENT"));
                d.setNom(rs.getString("NOM"));
                f.setDepartement(d);
                filieres.add(f);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return filieres;
    }

    @Override
    public List<Filiere> findAall() throws SQLException {
        return null;
    }

    @Override
    public Filiere findOne(int id) {
        Connection connection=ConnectionDB.getConnection();
        Filiere f=new Filiere();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from FILIERE where ID=?");
            stm.setInt(1,id);
            ResultSet rs=stm.executeQuery();

            if(rs.next()){
                f.setId(rs.getInt("ID"));
                f.setNom(rs.getString("NOM"));
                f.setDescription(rs.getString("DESCRIPTION"));
                f.setPrerequis(rs.getString("PRE_REQUIS"));


            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return f;    }

    @Override
    public Filiere save(Filiere o) {
        Connection connection=ConnectionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("insert into FILIERE(NOM,DESCRIPTION,PRE_REQUIS,ID_DEPARTEMENT) values(?,?,?,?)");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getDescription());
            pstm.setString(3,o.getPrerequis());
            pstm.setInt(4,o.getDepartement().getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return o;    }

    @Override
    public Boolean delete(Filiere o) {
        try{
            Connection connection=ConnectionDB.getConnection();
            PreparedStatement pstm=connection.prepareStatement("delete from FILIERE where ID=?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false ;
        }
        return true ;    }

    @Override
    public Filiere update(Filiere o) {
        Connection connection=ConnectionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("update FILIERE set NOM=?,DESCRIPTION=? ,PRE_REQUIS=? where ID=?");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getDescription());
            pstm.setString(3,o.getPrerequis());

            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return o;    }

    @Override
    public List<Filiere> findFilieresByMc(String mc) {
        Connection connection=ConnectionDB.getConnection();
        List<Filiere> filieres=new ArrayList<>();
        try{
            PreparedStatement pstm=connection.prepareStatement("select * from FILIERE where NOM like ?");
            pstm.setString(1,"%"+mc+"%");
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                Filiere f=new Filiere();
                f.setId(rs.getInt("ID"));
                f.setNom(rs.getString("NOM"));
                f.setDescription(rs.getString("DESCRIPTION"));
                f.setPrerequis(rs.getString("PRE_REQUIS"));

                filieres.add(f);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return filieres;
    }
}
