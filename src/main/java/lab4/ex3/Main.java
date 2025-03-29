package main.java.lab4.ex3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CinemaHall primaryCinemaHall = new CinemaHall();
        BookingPlanner primaryBookingPlanner = new BookingPlanner(primaryCinemaHall);

        primaryBookingPlanner.processReservation(new Customer("George","G.co"));
        primaryBookingPlanner.processReservation(new Customer("John","Johnson"));
        primaryBookingPlanner.processReservation(new Customer("Jane","Janez"));

        primaryBookingPlanner.printSeatingMap();
    }
}
