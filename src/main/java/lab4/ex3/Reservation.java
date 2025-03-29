package main.java.lab4.ex3;

public abstract class Reservation {
    private Customer customer;

    public Reservation(Customer customer) {
        this.customer = customer;
    }

    public abstract String getType();
    public abstract void reserve(CinemaHall hall);

    public Customer getCustomer() {
        return customer;
    }
}
