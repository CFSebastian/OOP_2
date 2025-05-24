package main.java.lab12.bank;

public class BankAc {
    private String name;
    private double balance;

    BankAc(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        synchronized (this) {
            this.balance += amount;
        }
    }
    public void withdraw(double amount) {
        synchronized (this) {
            this.balance -= amount;
        }
    }
    public double getBalance() {
        return balance;
    }

}
