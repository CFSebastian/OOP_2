package main.java.lab3.ex2;

public class Triangle extends Shape{
    private int area;
    Triangle(String color, int area) {
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
