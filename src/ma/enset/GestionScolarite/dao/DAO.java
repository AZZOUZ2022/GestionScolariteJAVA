package ma.enset.GestionScolarite.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {
    List<T> findAall() throws SQLException;
    T findOne(int id) throws SQLException;
    T save(T o) throws SQLException;
    Boolean delete(T o) throws SQLException;
    T update(T o) throws SQLException;
}
