package app;

import entities.Employe;
import service.EmployeService;

public class TestEmploye {
    public static void main(String[] args) {
        EmployeService svc = new EmployeService();

        try {
            Employe e1 = new Employe("Issam", "Chef de projet");
            svc.createEmploye(e1);
            System.out.println("Employé créé : ID=" + e1.getId());

            Employe e2 = new Employe("Achraf", "Développeur");
            svc.createEmploye(e2);
            System.out.println("Employé créé : ID=" + e2.getId());

            Employe e3 = new Employe("Mehdi", "Testeur");
            svc.createEmploye(e3);
            System.out.println("Employé créé : ID=" + e3.getId());

            System.out.println("\nListe des employés :");
            svc.listEmployes().forEach(emp ->
                    System.out.printf("%d : %s [%s]%n", emp.getId(), emp.getNom(), emp.getPoste())
            );

            e1.setPoste("Directeur technique");
            System.out.println("\nMise à jour OK ? " + svc.updateEmploye(e1));

            System.out.println("Suppression de Mehdi OK ? " + svc.deleteEmploye(e3));

            System.out.println("\nListe après suppression :");
            svc.listEmployes().forEach(emp ->
                    System.out.printf("%d : %s [%s]%n", emp.getId(), emp.getNom(), emp.getPoste())
            );

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}