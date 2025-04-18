package main.java.proiect;

import main.java.proiect.components.*;

import java.util.List;

public class PCBuilder {
    private Case pcCase;
    private Motherboard motherboard;
    private Processor processor;
    private GraphicsCard graphicsCard;
    private List<RAM> rams;
    private List<Storage>  storages;
    private PowerSupply powerSupply;

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public void setPCCase(Case pcCase) {
        this.pcCase = pcCase;
    }
    public void setRAMs(List<RAM> rams) {
        this.rams = rams;
    }
    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Computer createComputer() {
        return new Computer(pcCase,motherboard,processor,graphicsCard,powerSupply,rams,storages);
    }
}
