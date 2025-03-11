package main.java.lab1;

public class ContBancarVip extends ContBancar {
    private double points;
    public  ContBancarVip(int id, String name, double balance) {
        super(id, name, balance);
        points = 0;
    }

    @Override
    public int withdraw(double amount) {
        this.setBalance(getBalance()- amount);
        //super.withdraw(amount);// echivalent cu instructiunea de mai sus doar ca se afiseaza si mesaj, nu am mai vrut mesaj
        this.points += amount%100;
        System.out.println("Successfully VIP withdraw \n");
        return 0;
    }

}
