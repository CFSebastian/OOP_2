package main.java.lab3.ex2;

public class Square extends Shape {
    private int area;
    Square(String color, int area) {
        this.color = color;
        this.area = area;
    }
    @Override
    public int getArea() {
        return this.area;
    }
    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
