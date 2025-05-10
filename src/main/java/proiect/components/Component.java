package main.java.proiect.components;

public abstract class Component {
    private long id;
    private String name;
    private double price;
    private int power = -1;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Component(String name, double price, int power) {
        this.name = name;
        this.price = price;
        this.power = power;
    }

    public Component(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Component(long id, String name, double price, int power) {
        this(id,name, price);
        this.power = power;
    }

    public abstract String type();
    public void print() {
        System.out.println(this.name + "\n\t = " + this.price);
    }

    public long getId() {   return id;  }

    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public int getPower() {
        return power;
    }

    public void setPower(int power) { this.power = power; }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", power='" + power +
                '}';
    }
}
