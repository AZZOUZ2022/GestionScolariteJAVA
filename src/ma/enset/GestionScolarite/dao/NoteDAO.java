package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Note;

import java.sql.SQLException;
import java.util.List;

public interface NoteDAO extends DAO<Note> {
    List<Note> findAall() throws SQLException;
    Note findOne(int idE, int idEDM, String type_) throws SQLException;
    Note save(Note note) throws SQLException;
    Boolean delete(Note note) throws SQLException;
    Note update(Note note) throws SQLException;
}
