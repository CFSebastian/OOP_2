package main.java.lab4.ex1;

import java.util.ArrayList;

public class School {
    private Student[] students;
    private Schedule[] schedules;
    private Classroom[] classrooms;

    public School(Student[] students) {
        this.students = students;
        this.schedules = new Schedule[]{
                new Schedule("Monday", 1),
                new Schedule("Tuesday", 2)
        };
        this.classrooms = new Classroom[]{
                new Classroom(1,"Chemistry")
        };
    }
    public int numberOfClassrooms() {
        return classrooms.length;
    }
}
