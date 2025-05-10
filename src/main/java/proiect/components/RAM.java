package main.java.proiect.components;

public class RAM extends Component{
    private int memory = 0;
    private int frequency = 0;
    private String technology = "";
    public RAM(long id,String name, double price) {
        super(id,name,price);
    }
    public RAM(long id,String name, double price, int memory, int frequency, String technology) {
        super(id,name,price,10);
        this.memory = memory;
        this.frequency = frequency;
        this.technology = technology;
    }

    public String type() {
        return "RAM";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.memory + "\n\t - " + this.frequency + "\n\t - " + this.technology + "\n\t = "+this.getPrice());
    }

    public int getMemory() {
        return memory;
    }
    public int getFrequency() {
        return frequency;
    }
    public String getTechnology() {
        return technology;
    }
}
