package main.java.lab2;

import java.util.List;

public class ManagementService {
    private static ManagementService instance = null;

    private ManagementService() {}
    public static ManagementService getInstance() {
        if (instance == null) {
            instance = new ManagementService();
        }
        return instance;
    }

    public void inregistrareAngajat(Departament departament, Angajat angajat) {
        if(departament.isAngajatMember(angajat)) {
            System.out.println("Angajat inregistrat deja in departament"+"\n");
        }
        else {
            departament.uppdateMembri(angajat,1);
        }
    }
    public void schimbaDepartament(Departament departament, Angajat angajat) {
        angajat.departament.uppdateMembri(angajat,0);
        angajat.departament = departament;
        this.inregistrareAngajat(departament,angajat);
    }
    public void schimbaSalariu(Angajat angajat, int salary) {
        angajat.salary = salary;
    }
    public void afiseazaDepartamente(Departamente departamente) {
       for (int i =0; i<departamente.departamente.size();i++) {
           System.out.println(departamente.departamente.get(i).numeDepartament);
       }
    }
    public void afiseazaMembriPerDepart(Departamente departamente) {
        for (int i =0; i<departamente.departamente.size();i++) {
            departamente.departamente.get(i).printNumarAngajati();
            departamente.departamente.get(i).printMembri();
        }
    }
    public void salaiuMediuDep (Departament departament) {
        List<Angajat> membriDep = departament.getMembri();
        int deparmentSalaryMean = 0;
        int numarMembriDep =departament.getNumarAngajati();
        for (Angajat angajat : membriDep) {
            deparmentSalaryMean += angajat.salary;
        }
        deparmentSalaryMean = deparmentSalaryMean / numarMembriDep;
        System.out.println("Medie salariu depertament selectat: " + deparmentSalaryMean+"\n");
    }
}
