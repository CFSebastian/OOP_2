package main.java.lab3.ex1;

public class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
