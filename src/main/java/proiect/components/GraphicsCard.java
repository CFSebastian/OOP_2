package main.java.proiect.components;

public class GraphicsCard extends Component {
    private int vRAM = 0;
    public GraphicsCard(String name, double price) {
        super(name, price);
    }

    public GraphicsCard(String name, double price, int vRAM,  int power) {
        super(name, price,power);
        this.vRAM = vRAM;
    }

    public String type() {
        return "GPU";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.vRAM + "\n\t = " + this.getPrice());
    }
}
