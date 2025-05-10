package main.java.proiect.components;


public class Storage extends Component {
    public int memory = 0;
    public Storage(long id,String name, double price) {
        super(id,name,price);
    }
    public Storage(long id,String name, double price, int memory) {
        super(id,name,price,15);
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
