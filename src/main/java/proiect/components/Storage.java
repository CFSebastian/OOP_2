package main.java.proiect.components;


public class Storage extends Component {
    private int memory = 0;
    public Storage(long id,String name, double price) {
        super(id,name,price);
    }
    public Storage(long id,String name, double price, int memory) {
        super(id,name,price,15);
        this.memory = memory;
    }

    public Storage(String name, double price) {
        super(name,price);
    }
    public Storage(String name, double price, int memory) {
        super(name,price,15);
        this.memory = memory;
    }

    public Storage(long id,String name, double price, int power, int memory) {
        super(id,name,price,power);
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

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", power='" + this.getPower() + '\'' +
                ", memory='" + this.memory  + '\''+
                '}';
    }
}
