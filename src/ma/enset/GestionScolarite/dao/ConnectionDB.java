package ma.enset.GestionScolarite.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionscolarite", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
