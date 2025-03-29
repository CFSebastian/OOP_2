package main.java.lab4.ex3;
import java.util.Scanner;

public class RegularReservation extends Reservation {
    RegularReservation(Customer customer) {
        super(customer);
    }


    @Override
    public String getType() {
        return "Regular";
    }
    @Override
    public void reserve(CinemaHall hall) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter seat line: ");
        int line = input.nextInt();
        System.out.print("Enter seat column: ");
        int column = input.nextInt();
        if(hall.checkSeat(line,column)==false) {
            hall.bookSear(line, column, this.getCustomer());
            System.out.print("Seat reserved");
        } else {
            System.out.println("Seat is already reserved");
        }

    }
}
