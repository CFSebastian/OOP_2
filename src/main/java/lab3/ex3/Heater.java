package main.java.lab3.ex3;

public class Heater extends Appliance{
    private static int index =0;
    private int id;

    public Heater(int power, int priority, boolean nightMode) {
        super(power,priority,nightMode);
        id = index++;
    }

    @Override
    public void switchOn() {
        this.setStatus(true);
    }

    @Override
    public void switchOff() {
        this.setStatus(false);
    }

    @Override
    public String getType() {
        return "HEATER-"+id;
    }
}
