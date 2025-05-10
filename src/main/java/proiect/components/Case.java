package main.java.proiect.components;

public class Case extends Component {
    private String formFactor = "";
    public Case (long id, String name, double price) {
        super(id,name,price);
    }
    public Case (long id,String name, double price , String formFactor) {
        super(id,name,price,10);
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
