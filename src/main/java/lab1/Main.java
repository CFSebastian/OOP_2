package main.java.lab1;
 import java.util.Scanner;
 import java.io.*; // No console available

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Utilizator Client1 = new Utilizator("Sebi",23);

        System.out.println("Username: " + Client1.getName() + "\n");
        System.out.println("Numar conturi: "+Client1.getNrContBancare()+"\n");

        while(true){
            System.out.print("Commands: exit,withdraw,balance,withdrawFrom,depositFrom \n Command:");
            String command = input.nextLine();
            if(command.equals("exit")){
                break;
            }
            switch(command){
                case "withdraw" ->{
                    double amount = input.nextDouble();
                    Client1.actions(amount,0);
                }
                case "balance" ->{
                    int amount = input.nextInt();
                    Client1.showBalance(amount);
                }
                case "deposit" ->{
                    String amount = input.next();
                    Client1.actions(Double.parseDouble(amount),1);
                }
                case "withdrawFrom" ->{
                    double amount = input.nextDouble();
                    int conturi = input.nextInt();
                    Client1.actions(amount,0,conturi);
                }
                case "depositFrom" ->{
                    double amount = input.nextDouble();
                    int conturi = input.nextInt();
                    Client1.actions(amount,1,conturi);
                }
                default -> {
                    System.out.println("Invalid command");
                }
            }
            String enterCapture =  input.nextLine();
        }
        /*Client1.showBalance(0);
        Client1.actions(20,0);
        Client1.actions(30,1,0);
        Client1.actions(30,0,1);*/
        input.close();
    }
}
