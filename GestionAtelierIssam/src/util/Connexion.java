package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connexion {
    private static Connexion instance;
    private Connection conn;
    
    private static final String URL = "jdbc:mysql://localhost:3306/atelier_issam";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Connexion() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static synchronized Connexion getInstance() throws SQLException {
        if (instance == null || instance.conn.isClosed()) {
            instance = new Connexion();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return conn;
    }
}