package ma.enset.GestionScolarite.services;

import ma.enset.GestionScolarite.dao.EtudiantDAO;
import ma.enset.GestionScolarite.dao.EtudiantDAOImpl;
import ma.enset.GestionScolarite.dao.entites.Etudiant;

import java.sql.SQLException;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    EtudiantDAO etudiantDAOImpl = new EtudiantDAOImpl();

    public EtudiantServiceImpl() {
    }

    public EtudiantServiceImpl(EtudiantDAO etudiantDAOImpl) {
        this.etudiantDAOImpl = etudiantDAOImpl;
    }

    @Override
    public List<Etudiant> getAllEtudiants() throws SQLException {
        return etudiantDAOImpl.findAall();
    }

    @Override
    public Etudiant getByName(String Nom, String Prenom) throws SQLException {
        return etudiantDAOImpl.findOneByName(Nom, Prenom);
    }

    @Override
    public Etudiant getOne(int id) throws SQLException {
        return etudiantDAOImpl.findOne(id);
    }

    @Override
    public Etudiant getByCNE(String CNE) throws SQLException {
        return etudiantDAOImpl.findOneCNE(CNE);
    }

    @Override
    public void addEtudiant(Etudiant etudiant) throws SQLException {
        etudiantDAOImpl.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) throws SQLException {
        etudiantDAOImpl.delete(etudiant);
    }

    @Override
    public void modifyEtudiant(Etudiant etudiant) throws SQLException {
        etudiantDAOImpl.update(etudiant);
    }
}
