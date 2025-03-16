package main.java.lab2;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Departament {
    //private static Departament instance = null;
    final String numeDepartament;
    private int numarAngajati;
    private List<Angajat> membri ;// Statica? - toate departamentele au eceasi lista de angajati?


    public Departament(String numeDepartament, int  numarAngajati,  List<Angajat> membri) {
        this.numeDepartament = numeDepartament;
        this.numarAngajati = numarAngajati;
        this.membri = (membri != null) ? membri : new ArrayList<>();
    }

    /*public static Departament getInstance(String numeDepartament, int  numarAngajati,  List<Angajat> membri) {
        if (instance == null) {
            instance = new Departament(numeDepartament, numarAngajati, membri);
        }
        return instance;
    }*/

    public void setNumarAngajati(int numarAngajati) {
        this.numarAngajati = numarAngajati;
    }
    public void uppdateMembri(Angajat angajat,int command) {
       // this.membri.add(angajat);

        switch (command) {
            case 0:
                if(this.membri.remove(angajat)) {
                    System.out.println("Membri remove succes"+"\n");
                }
                else {
                    System.out.println("Membri remove failed"+"\n");
                }
                break;
            case 1:
                this.membri.add(angajat);
                break;
            default:
                System.out.println("Error command"+"\n");
                break;
        }
        this.setNumarAngajati(this.membri.size());
    }
    public void printNumarAngajati() {
        System.out.println("Numara Angajati: " + this.numarAngajati+"\n");
    }
    public void printMembri() {
       for(int i=0;i<this.membri.size();i++) {
           System.out.println(this.membri.get(i).name+" "+this.membri.get(i).surname);
       }
    }
    public boolean isAngajatMember(Angajat angajat) {
        return this.membri.contains(angajat);
    }

    public List<Angajat> getMembri() {
        return this.membri;
    }
    public int getNumarAngajati() {
        return numarAngajati;
    }
}
