package main.java.proiect.components;

public class GraphicsCard extends Component {
    private int vRAM = 0;
    public GraphicsCard(long id,String name, double price) {
        super(id,name, price);
    }

    public GraphicsCard(long id,String name, double price, int vRAM,  int power) {
        super(id,name, price,power);
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
