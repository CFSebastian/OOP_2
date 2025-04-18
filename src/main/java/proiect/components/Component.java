package main.java.proiect.components;

public abstract class Component {
    private String name;
    private double price;
    private int power = -1;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Component(String name, double price, int power) {
        this(name, price);
        this.power = power;
    }

    public abstract String type();
    public void print() {
        System.out.println(this.name + "\n\t = " + this.price);
    }

    public int getPower() {
        return power;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
