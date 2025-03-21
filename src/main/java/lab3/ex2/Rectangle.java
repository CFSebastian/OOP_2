package main.java.lab3.ex2;

public class Rectangle extends Shape{
    private int area;
    Rectangle(String color, int area) {
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
