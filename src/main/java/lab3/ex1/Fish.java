package main.java.lab3.ex1;

public class Fish implements Animal {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
       return "Bloop";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
