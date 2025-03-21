package main.java.lab3.ex2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Rectangle("Red",14),
                new Triangle("Blue",10),
                new Square("Yellow",16)
        };
        Shape.countShapesInArray(shapes);

    }
}
