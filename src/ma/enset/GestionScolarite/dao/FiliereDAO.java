package ma.enset.GestionScolarite.dao;

import ma.enset.GestionScolarite.dao.entites.Filiere;

import java.util.List;

public interface FiliereDAO extends DAO<Filiere> {
    List<Filiere> findAll();

    List<Filiere> findFilieresByMc(String mc) ;

}
