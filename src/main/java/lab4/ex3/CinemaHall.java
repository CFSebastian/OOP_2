package main.java.lab4.ex3;

public class CinemaHall {
    private Seat[][]  seats;
    public CinemaHall() {
        seats = new Seat[10][10];
        for (int i = 0; i < 10; i++) {
            StringBuilder sd = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sd.append((char) (i + 64));
                sd.append(j);
                seats[i][j] = new Seat(false, sd.toString(), null);
                sd.delete(0, sd.length());
            }
        }
    }
    public void bookSear(int line, int column, Customer bookedBy) {
        StringBuilder sd = new StringBuilder();
        sd.append((char) (line + 64));
        sd.append(column);
        seats[line][column] = new Seat(true,sd.toString() , bookedBy);
    }
    public int seatsNumberOfLines() {
        return seats.length;
    }
    public int seatsNumberOfColumns() {
        return seats[0].length;

    }

    public boolean checkSeat(int line, int column) {
        return this.seats[line][column].booked();
    }


}
