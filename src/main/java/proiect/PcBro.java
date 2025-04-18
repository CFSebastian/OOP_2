package main.java.proiect;

import main.java.proiect.components.*;

import java.util.*;

public class PcBro {
    private static PcBro instance = null;
    private List<Component> componentsList = new ArrayList<Component>();
    private List<Computer> computerSugestions =  new ArrayList<>();
    private  PCBuilder myBuild = new PCBuilder();
    final String[] componentTypes = new String[]{"GPU","CPU","RAM","SSD","MB","PSU","CASE"};

    private PcBro() {}

    public static PcBro getInstance() {
        if(instance == null) {
            instance = new PcBro();
        }
        return instance;
    }

    public void addComponent(Component component) {
        componentsList.add(component);
    }
    public void addComputer(Computer computer) {
        computerSugestions.add(computer);
    }

    public void selectComponent(String type) {
        Scanner input = new Scanner(System.in);
        getComponentListOf(type);
        System.out.println("Select" + type + "id:");
        int id =input.nextInt();
        if(componentsList.get(id) != null){
            throw new PcComponentNotFound(type + "not found");
        }
        if(componentsList.get(id).type().equals(type)){
            throw new PcComponentNotFound(type +"not found, found something else");
        }
        switch(type){
            case "CPU" ->{
                myBuild.setProcessor((Processor)componentsList.get(id));
            }
            case "GPU" ->{
                myBuild.setGraphicsCard((GraphicsCard)componentsList.get(id));
            }
            case "RAM" ->{
                System.out.println("How many RAM sticks?");
                int number = input.nextInt();
                List<RAM> ramList = new ArrayList<>();
                for (int i=0;i<number;i++){
                    ramList.add((RAM)componentsList.get(id));
                }
                myBuild.setRAMs(ramList);
            }
            case "MB" ->{
                myBuild.setMotherboard((Motherboard)componentsList.get(id));
            }

            case "SSD" ->{
                System.out.println("How many storage modules?");
                int number = input.nextInt();
                List<Storage> storageList = new ArrayList<>();
                for (int i=0;i<number;i++){
                    storageList.add((Storage) componentsList.get(id));
                }
                myBuild.setStorages(storageList);
            }
            case "PSU" ->{
                myBuild.setPowerSupply((PowerSupply) componentsList.get(id));
            }
            case "CASE" ->{
                myBuild.setPCCase((Case) componentsList.get(id));
            }
            default ->{
                System.out.println("*******************Invalid Input**************************");
            }
        }

    }

    public void buildPc() {
        try{
            for(String type : componentTypes){
                selectComponent(type);
            }
        }catch(PcComponentNotFound e){
            System.err.println(e.getMessage() + "\n PLease try again");
            return;
        }

        Computer computer = myBuild.createComputer();

        if(!computer.verifyCompatibility()) {
            System.out.println("The components that you chose are not compatible");
            return;
        } else if (!computer.verifyCompatibilityBetweenRams()) {
            System.out.println("We sugest that you chose different RAMs that are more compatible between each other");
            return;
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("There are no problems. You have a \" "+ computer.classifyPC() +"\" pc." +
                    "Total cost for the pc is:"+computer.pcPrice()+". Do you want to save the computer?(yes/no)");
            String choice = input.nextLine();
            if (choice.equals("yes")) {
                computerSugestions.add(computer);
            }
        }
    }

    public void recommendPc(String performance) {
        Collections.sort(computerSugestions,(c1,c2) -> {if(c1.pcPrice() == c2.pcPrice()) {return 0; } else if (c1.pcPrice() < c2.pcPrice()) { return -1; } return 1;});
        System.out.println(performance + "computers (from cheapest) are:");
        switch (performance) {
            case "ALL" -> {
                System.out.println("All computers (from cheapest) are:");
                if (computerSugestions.size() > 0) {
                    for (Computer computer : computerSugestions) {
                        computer.print();
                    }
                } else {
                    System.out.println("There are no computers");
                }
            }
            case "LOW","MEDIUM","HIGH" ->{
                System.out.println(performance + "performance computers (from cheapest) are:");
                for (Computer computer : computerSugestions) {
                    if (computer.classifyPC().equals(performance)) {
                        computer.print();
                    }
                }
            }
            default -> {
                System.out.println("Invalid performance");

            }

        }
    }

    public Computer selectPc() {
        System.out.println("Select a computer from the list:");
        Computer finalComputer = myBuild.createComputer();
        System.out.print("* - ");
        finalComputer.print();
        for(int i = 0; i < computerSugestions.size(); i++) {
            System.out.print(i + " - ");
            computerSugestions.get(i).print();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Select Pc id");
        String pcId = input.nextLine();
        if(pcId.equals("*")){
            return finalComputer;
        } else {
            finalComputer = computerSugestions.get(Integer.parseInt(pcId));
        }
        return finalComputer;
    }

    public void  getComponentListOf(String type) {
        if(type.equals("ALL")){
            for  (Component component : componentsList) {
                System.out.println(componentsList.indexOf(component)+ "|" + component.getName());
            }
        } else {
            for (Component component : componentsList) {
                if (component.toString().equals(type)) {
                    System.out.println(componentsList.indexOf(component) + "|" + component.getName());
                }
            }
        }
    }

}
