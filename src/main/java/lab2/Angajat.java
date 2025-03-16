package main.java.lab2;

public class Angajat {
    String name;
    String surname;
    int year;
    int salary;
    Departament departament;

    public Angajat(String name, String surname, int year, int salary, Departament departament) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.salary = salary;
        this.departament = departament;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Angajat other = (Angajat) obj;
        if(this.surname.equals(other.surname) && this.name.equals(other.name) &&
                this.year == other.year && this.departament.equals(other.departament)) {
            return true;
        }
        return false;
    }
}
