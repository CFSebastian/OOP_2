package main.java.lab3.ex1;


public class Main {
    public static void main(String[] args) {
        Animal[]  animals = new Animal[]{
                new Dog("Rex"),
                new Cat("Miti"),
                new Fish("Nemo")
        };

        for(int i =0; i <  animals.length; i++) {
            System.out.println(i + "." + animals[i].getClass().getSimpleName()
            + " (" + animals[i].getName() +"):" + animals[i].makeSound());

        }
    }
}
