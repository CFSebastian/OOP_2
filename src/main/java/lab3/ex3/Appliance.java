package main.java.lab3.ex3;

public abstract class Appliance implements Switchable {
    private int power;
    private boolean status;
    private int priority;
    private boolean nightMode;

    Appliance() {
        this.power = -1;
        this.status = false;
    }

    Appliance(int power,int priority, boolean nightMode) {
        this.power = power;
        this.priority = priority;
        this.status = false;
        this.nightMode = nightMode;
    }

    public abstract String getType();

    public void toggleAppliance() {
        if (this.status ==  true) {
            this.switchOff();
        } else {
            this.switchOn();
        }
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean getNightMode() {
        return this.nightMode;
    }
}
