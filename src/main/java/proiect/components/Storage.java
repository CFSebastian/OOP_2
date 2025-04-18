package main.java.proiect.components;


public class Storage extends Component {
    public int memory = 0;
    public Storage(String name, double price) {
        super(name,price);
    }
    public Storage(String name, double price, int memory) {
        super(name,price,15);
        this.memory = memory;

    }

    public String type() {
        return "SSD";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.memory + "\n\t - " + this.type() + "\n\t = "+this.getPrice());
    }

    public int getMemory() {
        return memory;
    }
}
