package main.java.lab3.ex3;

import java.util.ArrayList;

public class SmartHomeControler {
    private ArrayList<Appliance> appliances = new ArrayList<>();

    private static SmartHomeControler instance = null;

    SmartHomeControler(ArrayList<Appliance> appliances) {
        this.appliances = appliances;
    }

    public static SmartHomeControler getInstance(ArrayList<Appliance> appliances) {
        if (instance == null) {
            instance = new SmartHomeControler(appliances);
        }
        return instance;
    }

    public void addAppliance(Appliance appliance) {
        this.appliances.add(appliance);
    }

    public void turnOnAppliances() {
        for (Appliance appliance : this.appliances) {
            if(appliance.getStatus() ==  false) {
                appliance.toggleAppliance();
            }
        }
    }

    public void turnOffAppliances() {
        for (Appliance appliance : this.appliances) {
            if(appliance.getStatus() ==  true) {
                appliance.toggleAppliance();
            }
        }
    }

    public void countOnAppliances() {
        int couterAppliances = 0;
        for (Appliance appliance : this.appliances) {
            if(appliance.getStatus() ==  true) {
                couterAppliances++;
            }
        }
        System.out.println("Appliance Count: " + couterAppliances);
    }

    public int appliancesPoweConsumpion() {
        int powerConsuption = 0;
        for (Appliance appliance : this.appliances) {
            if(appliance.getStatus() ==  true) {
                powerConsuption += appliance.getPower();
            }
        }
        return powerConsuption;
    }

    public void appliancesStatusReport() {
        System.out.println("Appliance Status:");
        for (Appliance appliance : this.appliances) {
            System.out.println(appliance.getType() + "=> status:" + appliance.getStatus() +
                    "| priority:" + appliance.getPriority()+
                    "| night_mode:" + appliance.getNightMode()+
                    "| consuption:" +((appliance.getStatus()==true)?appliance.getPower():"0"));
        }
    }

    public void nightMode(int time) {
        if((time >= 22 && time <= 24) || (time >= 0 && time <=7)) {
            for (Appliance appliance : this.appliances) {
                if(appliance.getStatus() ==  true && appliance.getNightMode() == false) {
                    appliance.toggleAppliance();
                }
            }
        }
    }

    public void optimizeAppliances() {
        while(this.appliancesPoweConsumpion() > 200) {
            int minPriority = Integer.MAX_VALUE;
            for (Appliance appliance : this.appliances) {
                if (appliance.getPriority() < minPriority) {
                    minPriority = appliance.getPriority();
                }
            }
            for(Appliance appliance1 : this.appliances) {
                if(appliance1.getPriority() == minPriority) {
                    appliance1.toggleAppliance();
                }
            }

        }
    }

}
