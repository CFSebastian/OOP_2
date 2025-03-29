package main.java.lab4.ex3;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingPlanner implements Bookable {
    private CinemaHall cinemaHall;
    private ArrayList<Reservation> reservations;

    public BookingPlanner(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
        reservations = new ArrayList<>();
    }

    @Override
    public void processReservation(Customer customer) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter type: ");
        String type = input.nextLine();
        /*System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();*/

        switch (type) {
            case "Regular":
                reservations.add(new RegularReservation(customer));
                reservations.getLast().reserve(cinemaHall);
                break;
            case "VIP":
                reservations.add(new VIPReservation(customer));
                reservations.getLast().reserve(cinemaHall);
                break;
            default:
                System.out.println("Invalid type");
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
