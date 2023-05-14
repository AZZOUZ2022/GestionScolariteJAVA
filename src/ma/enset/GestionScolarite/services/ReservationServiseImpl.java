package ma.enset.GestionScolarite.services;


import ma.enset.GestionScolarite.dao.DeparDAO;
import ma.enset.GestionScolarite.dao.FiliereDAO;
import ma.enset.GestionScolarite.dao.entites.Departement;
import ma.enset.GestionScolarite.dao.entites.Filiere;


import java.sql.SQLException;
import java.util.List;

public class ReservationServiseImpl implements ReservationService{
    private FiliereDAO filiereDao;
    private DeparDAO deparDao;

    public ReservationServiseImpl(FiliereDAO filiereDao, DeparDAO deparDao) {
        this.filiereDao = filiereDao;
        this.deparDao = deparDao;
    }

    @Override
    public List<Filiere> getAllFilieres() throws SQLException {
        return filiereDao.findAll();
    }

    @Override
    public void addFiliere(Filiere p) throws SQLException {
        filiereDao.save(p);
    }

    @Override
    public void deleteFiliere(Filiere p) throws SQLException {
      filiereDao.delete(p);
    }

    @Override
    public List<Filiere> getFiliereParMc(String mc) {
        return filiereDao.findFilieresByMc(mc);
    }

    @Override
    public List<Departement> getAllDepartement() throws SQLException {
        return deparDao.findAll();
    }

    @Override
    public Departement getDepartementById(int id) throws SQLException {
        return deparDao.findOne(id);
    }

    @Override
    public void addDepartement(Departement c) throws SQLException {
         deparDao.save(c);
    }

    @Override
    public void delDepartement(Departement c) throws SQLException {
         deparDao.delete(c);
    }
}
