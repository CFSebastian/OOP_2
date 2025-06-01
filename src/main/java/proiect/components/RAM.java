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

    public RAM(String name, double price) {
        super(name,price);
    }
    public RAM(String name, double price, int memory, int frequency, String technology) {
        super(name,price,10);
        this.memory = memory;
        this.frequency = frequency;
        this.technology = technology;
    }

    public RAM(long id,String name, double price, int power, int memory, int frequency, String technology) {
        super(id,name,price,power);
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

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", power='" + this.getPower() + '\'' +
                ", memory=" + this.memory + '\'' +
                ", frequency=" + this.frequency + '\'' +
                ", technology='" + this.technology  + '\''+
                '}';
    }
}
