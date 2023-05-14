package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.AbsenceDAOimpl;
import ma.enset.GestionScolarite.dao.entites.Absence;

import java.sql.SQLException;
import java.util.List;

public class AbsenceServiceImpl implements AbsenceService{
    AbsenceDAOimpl absenceDAOimpl = new AbsenceDAOimpl();

    public AbsenceServiceImpl() {
    }

    public AbsenceServiceImpl(AbsenceDAOimpl absenceDAOimpl) {
        this.absenceDAOimpl = absenceDAOimpl;
    }

    @Override
    public List<Absence> getAllAbs() throws SQLException {
        return absenceDAOimpl.findAall();
    }

    @Override
    public Absence getAllAbs(int idE, int idEDM) throws SQLException {
        return absenceDAOimpl.findOne(idE, idEDM);
    }

    @Override
    public List<Absence> getAllAbsM(int idE, int idEDM) throws SQLException {
        return absenceDAOimpl.findOneMany(idE, idEDM);
    }

    @Override
    public Absence getOne(String nom) {
        return null;
    }

    @Override
    public void addAbs(Absence absence) throws SQLException {
        absenceDAOimpl.save(absence);
    }

    @Override
    public void deleteAbs(Absence absence) throws SQLException {
        absenceDAOimpl.delete(absence);
    }

    @Override
    public void modifyAbs(Absence absence) throws SQLException {
        absenceDAOimpl.update(absence);
    }
}
