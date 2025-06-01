package main.java.proiect.components;

public class Processor extends Component{
    private int coreNumber = 0;
    private float frequency = 0;
    private String socket = "";

    public Processor(long id,String name, double price) {
        super(id,name, price);
    }
    public Processor(long id,String name, double price, int coreNumber, float frequency, int power, String socket) {
        super(id,name, price,power);
        this.coreNumber = coreNumber;
        this.frequency = frequency;
        this.socket = socket;
    }

    public Processor(String name, double price) {
        super(name, price);
    }
    public Processor(String name, double price, int coreNumber, float frequency, int power, String socket) {
        super(name, price,power);
        this.coreNumber = coreNumber;
        this.frequency = frequency;
        this.socket = socket;
    }

    public String type() {
        return "CPU";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.coreNumber + "\n\t - " + this.frequency + "\n\t - " + this.socket + "\n\t = "+this.getPrice());
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Proccesor{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", power='" + this.getPower() + '\'' +
                ", coreNumber=" + coreNumber + '\'' +
                ", frequency=" + frequency + '\'' +
                ", socket='" + socket  + '\''+
                '}';
    }
}
