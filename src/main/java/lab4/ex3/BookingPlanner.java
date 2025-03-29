package main.java.lab4.ex3;
import java.util.Scanner;

public class BookingPlanner implements Bookable {
    private Reservation[] reservations;
    private CinemaHall cinemaHall;

    @Override
    public void processReservation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter type: ");
        String type = input.nextLine();
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        int i = reservations.length;
        i++;

        switch (type) {
            case "Regular":
                reservations[i] = new RegularReservation(new Customer(name,email));
                break;
            case "VIP":
                reservations[i] = new VIPReservation(new Customer(name,email));
                break;
        }
    }

    @Override
    public void printSeatingMap() {
        for(int i=0;i< cinemaHall.seatsNumberOfColumns();i++) {
            for(int j=0;j<cinemaHall.seatsNumberOfColumns();j++) {
                if(cinemaHall.checkSeat(i,j)==false) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println("Row "+(char)(i+'A'));
        }
    }
}
