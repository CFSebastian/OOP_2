package main.java.lab1;

public class ContBancar {
    private int id;
    protected String name;
    private double balance;

    ContBancar(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int deposit(double amount) {
        this.balance += amount;
        System.out.println("Successfully deposit \n");
        return 0;
    }
    public int withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Successfully deposit \n");
        }
        else {
            System.out.println("Insufficient funds \n");
        }
        return 0;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
