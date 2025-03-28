package main.java.lab4.ex2;
import main.java.lab4.ex1.School;
import main.java.lab4.ex1.Student;

public class Main {
    public static void main(String[] args) {
        School school1 = new School(new Student[]{
                new Student("Sebi","Colt",22)
        });

        StudentReport rep1 = new StudentReport("Sebi");
        SchoolSummaryReport rep2 = new SchoolSummaryReport(school1.numberOfClassrooms());

        String[][] Arg1 = new String[1][2];
        //rep1.generate("Nemultumire 1", "Nemultumire 2");
        //rep1.generate("Neconform 1", "Neconform 2");
    }
}
