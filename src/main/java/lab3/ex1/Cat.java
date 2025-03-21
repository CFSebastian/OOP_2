package main.java.lab3.ex1;


public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Meau!";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
