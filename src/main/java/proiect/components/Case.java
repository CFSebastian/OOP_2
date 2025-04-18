package main.java.proiect.components;

public class Case extends Component {
    private String formFactor = "";
    public Case (String name, double price) {
        super(name,price);
    }
    public Case (String name, double price , String formFactor) {
        super(name,price,10);
        this.formFactor = formFactor;
    }

    public String type() {
        return "CASE";
    }

    @Override
    public void print() {
        System.out.println(this.getName() + "\n\t - " + this.formFactor + "\n\t = " + this.getPrice());
    }
    public String getFormFactor() {
        return formFactor;
    }
}
