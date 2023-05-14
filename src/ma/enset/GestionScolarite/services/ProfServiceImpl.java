package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.ProfDAO;
import ma.enset.GestionScolarite.dao.ProfDAOImpl;
import ma.enset.GestionScolarite.dao.entites.Note;
import ma.enset.GestionScolarite.dao.entites.Prof;

import java.sql.SQLException;
import java.util.List;

public class ProfServiceImpl implements ProfService {
    ProfDAO profDAOimpl = new ProfDAOImpl();

    public ProfServiceImpl() {
    }

    public ProfServiceImpl(ProfDAO profDAOimpl) {
        this.profDAOimpl = profDAOimpl;
    }

    @Override
    public List<Prof> getAllProfs() throws SQLException {
        return profDAOimpl.findAall();
    }

    @Override
    public void addProf(Prof prof) throws SQLException {
        profDAOimpl.save(prof);
    }

    @Override
    public void deleteProf(Prof prof) throws SQLException {
        profDAOimpl.delete(prof);
    }

    @Override
    public void modifyProf(Prof prof) throws SQLException {
        profDAOimpl.update(prof);
    }
}
