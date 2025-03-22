package main.java.lab3.ex3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        ArrayList<Appliance> appliances = new ArrayList<>();
        appliances.add(new AC(100,10,true)) ;
        appliances.add(new Fan(30,5,false));
        appliances.add(new Heater(70,9,true));
        appliances.add(new Light(10,3,false));
        appliances.add(new Light(5,3,false));
        System.out.println("-----------------------------------");
        SmartHomeControler appliancesControler = SmartHomeControler.getInstance(appliances);
        System.out.println("-----------------------------------");

        appliancesControler.appliancesStatusReport();
        System.out.println("-----------------------------------");

        appliancesControler.turnOnAppliances();
        appliancesControler.appliancesStatusReport();
        System.out.println("-----------------------------------");

        appliancesControler.turnOffAppliances();
        appliancesControler.appliancesStatusReport();
        System.out.println("-----------------------------------");

        appliancesControler.countOnAppliances();
        System.out.println("-----------------------------------");

        appliancesControler.turnOnAppliances();
        appliancesControler.countOnAppliances();
        System.out.println("-----------------------------------");

        System.out.println("Consumption: "+appliancesControler.appliancesPoweConsumpion());
        System.out.println("-----------------------------------");

        appliancesControler.turnOffAppliances();
        System.out.println("Consumption: "+appliancesControler.appliancesPoweConsumpion());
        System.out.println("-----------------------------------");

        appliancesControler.turnOnAppliances();
        appliancesControler.nightMode(4);
        appliancesControler.appliancesStatusReport();
        System.out.println("-----------------------------------");

        appliancesControler.turnOnAppliances();
        appliancesControler.optimizeAppliances();
        appliancesControler.appliancesStatusReport();
        System.out.println("-----------------------------------");

    }
}
