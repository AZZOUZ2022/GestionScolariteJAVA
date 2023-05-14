package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.NoteDAO;
import ma.enset.GestionScolarite.dao.NoteDAOImpl;
import ma.enset.GestionScolarite.dao.entites.Note;

import java.sql.SQLException;
import java.util.List;

public class NoteServiceImpl implements NoteService{
    NoteDAO noteDAOImpl = new NoteDAOImpl();

    public NoteServiceImpl() {
    }

    public NoteServiceImpl(NoteDAO noteDAOImpl) {
        this.noteDAOImpl = noteDAOImpl;
    }

    @Override
    public List<Note> getAllNotes() throws SQLException {
        return noteDAOImpl.findAall();
    }

    @Override
    public Note getNote(int idEDM, int idE, String type_) throws SQLException {
        return noteDAOImpl.findOne(idEDM, idE, type_);
    }

    @Override
    public void addNote(Note note) throws SQLException {
        noteDAOImpl.save(note);
    }

    @Override
    public void deleteNote(Note note) throws SQLException {
        noteDAOImpl.delete(note);
    }

    @Override
    public void modifyNote(Note note) throws SQLException {
        noteDAOImpl.update(note);
    }
}
