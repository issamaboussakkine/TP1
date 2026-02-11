/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databyissamapp;
import java.sql.*;
import java.util.Scanner; 

/**
 *
 * @author ASUS
 */
public class DataByIssamApp {
    
private static final String URL = "jdbc:mysql://localhost:3306/databyissam";
    private static final String USER = "root";
    private static final String PASSWORD = "";
   
    public static void main(String[] args) {
 try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Driver MySQL est pret et  conneecte par Issam");
        } catch (ClassNotFoundException e) {
            System.out.println(" Impossible de trouver le Driver MySQL ton .jar");
            System.out.println(" Verifie tes librairies!");

            e.printStackTrace();
            return;
        }
 try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
     Statement stmt = conn.createStatement()) {
 
    System.out.println(" Base databyissam connectée!");
    
    stmt.executeUpdate("DROP TABLE IF EXISTS Issam_DevData");
    
    stmt.executeUpdate(
        "CREATE TABLE Issam_DevData (" +
        "Developpeurs VARCHAR(32) NOT NULL, " +
        "Jour VARCHAR(16) NOT NULL, " +
        "NbScripts INT NOT NULL" +
        ")"
    );
    stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('ISSAM', 'Lundi', 5)");
stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('ACHRAF', 'Lundi', 2)");
stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('MEHDI', 'Mardi', 9)");
stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('ISSAM', 'Mardi', 3)");
stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('ACHRAF', 'Mercredi', 4)");
stmt.executeUpdate("INSERT INTO Issam_DevData VALUES ('MEHDI', 'Mercredi', 2)");
    
    System.out.println(" Table Issam_DevData créée");
        System.out.println("Insertion terminer avec succes par Issam");
        
            System.out.println("\n LES STATISTIQUES :");
        System.out.println("\n--- Max scripts par jour ---");
            try (ResultSet rs = stmt.executeQuery(
                    "SELECT Jour, Developpeurs, MAX(NbScripts) AS MaxScripts " +
                            "FROM  Issam_DevData GROUP BY Jour"
            )) {
                  while (rs.next()) {
                    String jour = rs.getString("Jour");
                    String dev = rs.getString("Developpeurs");
                    int max = rs.getInt("MaxScripts");
                    System.out.println(jour + " | " + dev + " | " + max);
                }
            
            }
            System.out.println("\n--- Classement des développeurs ---");

try (ResultSet rs = stmt.executeQuery(
        "SELECT Developpeurs, SUM(NbScripts) AS Total " +
        "FROM Issam_DevData " +                    
        "GROUP BY Developpeurs " +
        "ORDER BY Total DESC"
)) {
    while (rs.next()) {
        String developpeur = rs.getString("Developpeurs");
        int totalScripts = rs.getInt("Total");
        System.out.println(developpeur + " | " + totalScripts);
    }
}
        System.out.println("\n--- Total scripts semaine ---");

try (ResultSet rs = stmt.executeQuery(
        "SELECT SUM(NbScripts) AS TotalSemaine FROM Issam_DevData"  
)) {
    if (rs.next()) {
        int totalSemaine = rs.getInt("TotalSemaine");
        System.out.println("Total semaine : " + totalSemaine);
    }
}        
System.out.println("\n--- Total scripts pour un développeur ---");

String devCherche = "ISSAM"; 
 System.out.println("\n Extensions :");

Scanner clavier = new Scanner(System.in); 
System.out.print("Entrez le nom du développeur : ");
 devCherche = clavier.nextLine(); 

String sql = "SELECT SUM(NbScripts) AS TotalDev FROM Issam_DevData WHERE Developpeurs = ?";

try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, devCherche);
    
    try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            int total = rs.getInt("TotalDev");
            System.out.println("Total pour " + devCherche + " : " + total);
        }
    }
}
             
} catch (SQLException e) {
    System.out.println(" Erreur de connexion : " + e.getMessage());
    e.printStackTrace();
    }
  }
}