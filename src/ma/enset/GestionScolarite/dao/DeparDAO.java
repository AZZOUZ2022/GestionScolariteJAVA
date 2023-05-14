package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Departement;

import java.util.List;

public interface DeparDAO extends DAO<Departement>{

    List<Departement> findAll();
}
