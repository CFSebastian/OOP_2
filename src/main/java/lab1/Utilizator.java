package main.java.lab1;

public class Utilizator {
    private int cnp;
    private String name;
    private ContBancar contBancarPrincipal;
    private ContBancar[] conturi;

    Utilizator(String name, int cnp) {
        this.name = name;
        this.cnp = cnp;
        this.conturi = new ContBancar[]{
                new ContBancar(1,"Primar",100),
                new ContBancarVip(2,"Vip",200)
        };
        contBancarPrincipal =  conturi[0];
    }
    public int actions(double amount, int actionSlected) {//
        switch (actionSlected) {
            case 0 -> {
                if(contBancarPrincipal.withdraw(amount) == 0) {
                    return 0;
                }
            }
            case 1 -> {
                if(contBancarPrincipal.deposit(amount) == 0){
                    return 0;
                }
            }
            default -> {
                System.out.println("Error \n");
            }

        }
        return actionSlected;
    }
    public int actions(double amount, int actionSlected, int  nrContBancar) {
        switch (actionSlected) {
            case 0 -> {
                if(conturi[nrContBancar].withdraw(amount) == 0) {
                    return 0;
                }
            }
            case 1 -> {
                if(conturi[nrContBancar].deposit(amount) == 0){
                    return 0;
                }
            }
            default -> {
                System.out.println("Error \n");
            }

        }
        return actionSlected;
    }
    public void showBalance( int  nrContBancar) {
        System.out.println(conturi[nrContBancar].getBalance() +"\n");
    }
    public String getName() {
        return this.name;
    }
    public int getNrContBancare() {
        return conturi.length;
    }

}
