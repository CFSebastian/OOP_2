package main.java.lab4.ex3;

public class VIPReservation extends Reservation {
    VIPReservation(Customer customer) {
        super(customer);
    }

    @Override
    public String getType(){
        return "VIP";
    }

    @Override
    public void reserve(CinemaHall hall) {
        boolean flag = false;
        for(int i=0;i< hall.seatsNumberOfColumns();i++) {
            if(hall.checkSeat(0,i)==false) {
                hall.bookSear(0,i,this.getCustomer());
                flag = true;
            }
        }
        if(flag==false) {
            System.out.println("Could not reserve seat");
        } else {
            System.out.println("Reserved");
        }
    }
}
