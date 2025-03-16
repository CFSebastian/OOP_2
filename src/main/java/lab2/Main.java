package main.java.lab2;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        //System.out.println("Medie salariu depertament selectat: ");
        ManagementService Manager1 = ManagementService.getInstance();

        List<Departament> departamente =  new ArrayList<>();
        departamente.add(new Departament("HR",2,null));
        departamente.add(new Departament("Relatii Clienti",2,null));
        Angajat[]  angajati = new Angajat[]{
                new Angajat("Eduard","Mihai",2022,3000,departamente.get(0)),
                new Angajat("Sebi","Colt",2025,5000,departamente.get(0)),
                new Angajat("Razvan","Mihai",2025,4000,departamente.get(1)),
                new Angajat("Marius","A",2024,2000,departamente.get(1))
        };
        Manager1.inregistrareAngajat(departamente.get(0),angajati[0]);
        Manager1.inregistrareAngajat(departamente.get(0),angajati[1]);
        Manager1.inregistrareAngajat(departamente.get(1),angajati[2]);
        Manager1.inregistrareAngajat(departamente.get(1),angajati[3]);

        Departamente departamente1 = new Departamente(departamente);
        System.out.println("############################################################\n");
        Manager1.afiseazaDepartamente(departamente1);
        System.out.println("-------------------------------------------------------------\n");
        Manager1.afiseazaMembriPerDepart(departamente1);
        System.out.println("############################################################\n");

        Manager1.salaiuMediuDep(departamente.get(0));
        System.out.println("-------------------------------------------------------------\n");
        Manager1.salaiuMediuDep(departamente.get(1));
        System.out.println("############################################################\n");

        Manager1.schimbaDepartament(departamente.get(1),angajati[1]);
        Manager1.afiseazaMembriPerDepart(departamente1);
        System.out.println("############################################################\n");

        Manager1.schimbaSalariu(angajati[0],1000);
        Manager1.salaiuMediuDep(departamente.get(0));
        System.out.println("-------------------------------------------------------------\n");
        Manager1.salaiuMediuDep(departamente.get(1));
        System.out.println("############################################################\n");
    }
}
