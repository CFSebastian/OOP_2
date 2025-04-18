package main.java.proiect.components;

public class PowerSupply extends Component {
    private String powerEfficiency = "";
    public PowerSupply(String name, double price) {
        super(name,price);
    }
    public PowerSupply(String name, double price, String powerEfficiency, int power) {
        super(name,price,power);
        this.powerEfficiency = powerEfficiency;
    }

    public String type() {
        return "PSU";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.powerEfficiency + "\n\t = "+this.getPrice());
    }
}
