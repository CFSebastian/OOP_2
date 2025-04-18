package main.java.proiect.components;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Motherboard extends Component {
    //private List<Ports> ports =  new ArrayList<Ports>();
    private TreeMap<String,Integer> ports = new TreeMap<>();
    private String formFactor = "";
    private String socket = "";
    private String technology = "";//RAM
    public Motherboard(String name, double price) {
        super(name, price);
    }
    public Motherboard(String name, double price, String formFactor, String socket,String technology) {
        super(name, price,70);
        this.formFactor = formFactor;
        this.socket = socket;
        this.technology = technology;
    }
    public Motherboard(String name, double price, String formFactor, String socket, String technology, TreeMap<String,Integer> ports) {
        this(name, price, formFactor, socket, technology);
        this.ports = ports;
    }
    public String type() {
        return "MB";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.formFactor + " - " + this.socket + "\n\t  - " + this.technology);
        for (int i = 0; i < this.ports.size(); i++) {
            System.out.print(ports.get(i) + (i == this.ports.size() - 1 ? ";" : ","));
        }
        System.out.println("\n\t = " + this.getPrice());
    }

    public String getSocket() {
        return socket;
    }
    public String getTechnology() {
        return technology;
    }

    public String getFormFactor() {
        return formFactor;
    }
}
