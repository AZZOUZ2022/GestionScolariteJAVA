package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Note;
import ma.enset.GestionScolarite.dao.entites.Type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoteDAOImpl implements NoteDAO {
    @Override
    public List<Note> findAall() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from note");
        List<Note> notes = new ArrayList<>();
        String type;
        while (rs.next()) {
            Note note = new Note();
            note.setId(rs.getInt("Id"));
            note.setNote(rs.getFloat("Note"));
            type = rs.getString("Type");
            if (type == "Controle")
                note.setType(Type.Controle);
            else if (type == "Examen")
                note.setType(Type.Examen);
            else
                note.setType(Type.Autre);
            note.setIdEDM(rs.getInt("IdEDM"));
            note.setIdE(rs.getInt("IdE"));
            notes.add(note);
        }
        return notes;
    }

    @Override
    public Note findOne(int idEDM, int idE, String type_) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from note where idEDM = " + idEDM + " and idE = " + idE + " and Type = '" + type_ + "'");
        String type;
        Note note = new Note();
        while (rs.next()) {
            note.setId(rs.getInt("Id"));
            note.setNote(rs.getFloat("Note"));
            type = rs.getString("Type");
            if (type == "Controle")
                note.setType(Type.Controle);
            else if (type == "Examen")
                note.setType(Type.Examen);
            else
                note.setType(Type.Autre);
            note.setIdEDM(rs.getInt("IdEDM"));
            note.setIdE(rs.getInt("IdE"));
        }
        return note;
    }

    @Override
    public Note findOne(int id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("select * from note where id = " + id);
        String type;
        Note note = new Note();
        while (rs.next()) {
            note.setId(rs.getInt("Id"));
            note.setNote(rs.getFloat("Note"));
            type = rs.getString("Type");
            if (type == "Controle")
                note.setType(Type.Controle);
            else if (type == "Examen")
                note.setType(Type.Examen);
            else
                note.setType(Type.Autre);
            note.setIdEDM(rs.getInt("IdEDM"));
            note.setIdE(rs.getInt("IdE"));
        }
        return note;
    }

    @Override
    public Note save(Note note) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        String type;
        if (note.getType() == Type.Controle)
            type = "Controle";
        else if (note.getType() == Type.Examen)
            type = "Examen";
        else
            type = "Autre";
        stm.executeUpdate("insert into note(Note, Type, IdEDM, IdE) values (" + note.getNote() + ", '" + type + "', " + note.getIdEDM() +", "+ note.getIdE() +")");
        return note;
    }

    @Override
    public Boolean delete(Note note) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        int state = stm.executeUpdate("delete from note where Id = " + note.getId());
        if (state == 1)
            return true;
        else
            return false;
    }

    @Override
    public Note update(Note note) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Statement stm = connection.createStatement();
        String type;
        if (note.getType() == Type.Controle)
            type = "Controle";
        else if (note.getType() == Type.Examen)
            type = "Examen";
        else
            type = "Autre";
        stm.executeUpdate("update note set  Note = " + note.getNote() + " where Id = " + note.getId());
        ResultSet rs = stm.executeQuery("select * from note where Id = " + note.getId());
        while (rs.next()) {
            note.setId(rs.getInt("Id"));
            note.setNote(rs.getFloat("Note"));
            type = rs.getString("Type");
            if (type == "Controle")
                note.setType(Type.Controle);
            else if (type == "Examen")
                note.setType(Type.Examen);
            else
                note.setType(Type.Autre);
            note.setIdEDM(rs.getInt("IdEDM"));
            note.setIdE(rs.getInt("IdE"));
        }
        return note;
    }
}
