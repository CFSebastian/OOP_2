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

    public int getvRAM() {
        return vRAM;
    }

    public void setvRAM(int vRAM) {
        this.vRAM = vRAM;
    }

    @Override
    public String toString() {
        return "Proccesor{" +
                "id=" + this.getId() +
                ", price='" + this.getPrice() + '\'' +
                ", power='" + this.getPower() + '\'' +
                ", vRAM='" + vRAM +
                '}';
    }

}
