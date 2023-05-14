package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.entites.Note;

import java.sql.SQLException;
import java.util.List;

public interface NoteService {
    List<Note> getAllNotes() throws SQLException;
    Note getNote(int idEDM, int idE, String type_) throws SQLException;
    void addNote(Note note) throws SQLException;
    void deleteNote(Note note) throws SQLException;
    void modifyNote(Note note) throws SQLException;
}
