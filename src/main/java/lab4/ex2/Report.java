package main.java.lab4.ex2;

public abstract class Report {
    protected StringBuilder reportDraft = new StringBuilder();


    public abstract void generate(Object[]... args);

    public void print(){
        System.out.print(reportDraft.toString());
    }

}
