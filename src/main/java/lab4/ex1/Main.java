package main.java.lab4.ex1;

import main.java.lab4.ex3.Seat;

public class Main {
    public static void main(String[] args) {
        School school1 = new School(new Student[]{
                new Student("Sebi","Colt",22)
        });

        StudentReport rep1 = new StudentReport("Sebi");
        SchoolSummaryReport rep2 = new SchoolSummaryReport(school1.numberOfClassrooms());

        rep1.generate(school1.getStudents());
        rep2.generate(school1.getSchedules(), school1.getClassrooms());

        rep1.print();
        System.out.println("\n");
        rep2.print();

    }
}
