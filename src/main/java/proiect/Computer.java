package main.java.proiect;

import main.java.proiect.components.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Case pcCase = null;
    private Motherboard motherboard = null;
    private Processor processor = null;
    private GraphicsCard graphicsCard = null;
    private List<RAM> rams = new ArrayList<RAM>();
    private List<Storage>  storages = new ArrayList<>();
    private PowerSupply powerSupply  = null;

    public Computer() {}
    public Computer(Case pcCase,Motherboard motherboard, Processor processor, GraphicsCard graphicsCard, PowerSupply powerSupply,  List<RAM> rams, List<Storage> storages) {
        this.pcCase = pcCase;
        this.motherboard = motherboard;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.rams = rams;
        this.storages = storages;
        this.powerSupply = powerSupply;
    }

    public int calculatePowerConsumption() {
        int ramPowerConsuption = 0;
        int storagePowerConsuption = 0;
        for(RAM ram : rams) {
            ramPowerConsuption += ram.getPower();
        }
        for(Storage storage : storages) {
            storagePowerConsuption += storage.getPower();
        }
        int pcPowerConsuption = pcCase.getPower() + motherboard.getPower() + processor.getPower()
                + ramPowerConsuption + storagePowerConsuption - powerSupply.getPower();
        if(pcPowerConsuption <= 0) {
            return -1;
        } else if(pcPowerConsuption >= 100) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean verifyCompatibilityBetweenRams() {
        int ramMem = rams.get(0).getMemory();
        int ramFreq =  rams.get(0).getFrequency();
        for (int i = 1; i < rams.size(); i++) {
            if(rams.get(i).getMemory() != ramMem || rams.get(i).getFrequency() != ramFreq) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyCompatibility () {
        if(calculatePowerConsumption() == -1 || !motherboard.getSocket().equals(processor.getSocket()) || !motherboard.getFormFactor().equals(pcCase.getFormFactor())) {
            return false;
        }

        for(int i=0; i < rams.size(); i++) {
            if(motherboard.getTechnology().equals(rams.get(i).getTechnology())) {
                return false;
            }
        }
        return true;
    }

    public String classifyPC() {
        double price = pcPrice();
        if(price <= 3000) {
            return "LOW END";
        } else if(price >= 3000 && price <= 5000) {
            return "MID-END";
        } else if(price <= 7000) {
            return "HIGH END";
        }
        return null;
    }

    public double pcPrice() {
        int ramPrice = 0;
        int storagePrice = 0;
        for(RAM ram : rams) {
            ramPrice += ram.getPrice();
        }
        for(Storage storage : storages) {
            storagePrice += storage.getPrice();
        }
        return pcCase.getPrice() + motherboard.getPrice() + processor.getPrice()
                + ramPrice + storagePrice + powerSupply.getPrice();

    }

    public void print() {
        int ramMemory = 0;
        int storageMemory = 0;
        for (RAM ram : rams) {
            ramMemory += ram.getMemory();
        }
        for (Storage storage : storages) {
            storageMemory += storage.getMemory();
        }
        System.out.println("PC: \n\t - " + this.processor.getName() + "\n\t - " + this.graphicsCard.getName() + "\n\t - Ram:" + ramMemory + "\n\t - Storage"
                + storageMemory + "\n\t - " + this.powerSupply.getName() +  "\n\t - " + this.pcCase.getName() +  "\n\t - " + this.motherboard.getName() + "\n\t Price: " + this.pcPrice());
    }

}
