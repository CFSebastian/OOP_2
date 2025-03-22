package main.java.lab3.ex3;

public class AC extends Appliance{

    private static int index =0;
    private int id;

    public AC(int power, int priority, boolean nightMode) {
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
        return "AC-"+id;
    }
}
