package app;

import entities.Employe;
import entities.Machine;
import service.EmployeService;
import service.MachineService;

public class TestMachine {
    public static void main(String[] args) {
        MachineService mSvc = new MachineService();
        EmployeService eSvc = new EmployeService();

        try {
            Employe issam = new Employe("Issam", "Chef de projet");
            eSvc.createEmploye(issam);
            
            Employe achraf = new Employe("Achraf", "Développeur");
            eSvc.createEmploye(achraf);

            Machine m1 = new Machine("Lenovo ThinkPad", "Ordinateur", issam);
            mSvc.createMachine(m1);
            System.out.println("Machine créée : ID=" + m1.getId());
            
            Machine m2 = new Machine("MacBook Pro", "Ordinateur", issam);
            mSvc.createMachine(m2);
            System.out.println("Machine créée : ID=" + m2.getId());
            
            Machine m3 = new Machine("HP LaserJet", "Imprimante", achraf);
            mSvc.createMachine(m3);
            System.out.println("Machine créée : ID=" + m3.getId());

            System.out.println("\nListe des machines :");
            mSvc.listMachines().forEach(machine ->
                    System.out.printf("%d : %s [%s] → Employé=%s (%d)%n",
                            machine.getId(), machine.getNom(), machine.getType(),
                            machine.getEmploye().getNom(), machine.getEmploye().getId())
            );

            m1.setNom("Lenovo ThinkPad X1");
            m1.setType("Ordinateur haute performance");
            System.out.println("\nUpdate machine Issam OK ? " + mSvc.updateMachine(m1));
            
            System.out.println("Delete machine imprimante OK ? " + mSvc.deleteMachine(m3));

            System.out.println("\nListe des machines après modifications :");
            mSvc.listMachines().forEach(machine ->
                    System.out.printf("%d : %s [%s] → Employé=%s (%d)%n",
                            machine.getId(), machine.getNom(), machine.getType(),
                            machine.getEmploye().getNom(), machine.getEmploye().getId())
            );

            System.out.println("\nDelete employé Achraf OK ? " + eSvc.deleteEmploye(achraf));
            
            System.out.println("Delete employé Issam OK ? " + eSvc.deleteEmploye(issam));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}