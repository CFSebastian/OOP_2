package main.java.proiect;


import main.java.proiect.components.*;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        TreeMap<String,Integer> ports = new TreeMap<>();

        String[][] portType = new String[][]{{"USB3.0","2"},{"USB2.0","3"},{"USB-C","1"},{"JACK","1"}};

        for (int i=0;i<portType.length;i++) {
            ports.put(portType[i][0],Integer.parseInt(portType[i][1]));
        }

        Component[] components = new Component[]{
                new Processor(1,"Ryzen5 5600X",470d,6,3.7f,88,"AM4"),
                new GraphicsCard(2,"Radeon RX 6700XT",1200,12,230),
                new RAM(3,"FVulcan",100,8,3200,"DDR4"),
                new Motherboard(4,"B550 Gaming X V2",200,"ATX","AM4","DDR4",ports),
                new Storage(5,"Adata",200,1000),
                new PowerSupply(6,"BP750",400,"Gold",750),
                new Case(7,"Case",100,"ATX")
        };

        Scanner input = new Scanner(System.in);

        Computer finalComputer =null;

        PcBro helper = PcBro.getInstance();
        for(Component component : components) {
            helper.addComponent(component);
        }

        boolean appOn = true;

        while(appOn){
            System.out.print("Possible commands:\n\t- exit\n\t- build pc" +
                    "\n\t- recommend pc\n\t- select a pc\n\t- view components\nEnter command:");
            String command = input.nextLine().trim();
            switch (command) {
                case "exit" -> {
                    appOn = false;
                }
                case "build pc" -> {
                    helper.buildPc();
                }
                case "select a pc" -> {
                    finalComputer = helper.selectPc();
                }
                case "view components" -> {
                    System.out.println("Enter components type from the following:" +
                            "\n\t - ALL - for all components" +
                            "\n\t - GPU - for graphics card" +
                            "\n\t - CPU - for processor" +
                            "\n\t - RAM - for ram memory" +
                            "\n\t - SSD - for storage memory" +
                            "\n\t - PSU - for power supply" +
                            "\n\t - CASE - for the pc case");
                    String componentType = input.nextLine().trim();
                    helper.getComponentListOf(componentType);
                }
                case "recommend pc" -> {
                    System.out.println("Enter the performance that you are looking for. You can select the following:" +
                            "\n\t - All" +
                            "\n\t - LOW" +
                            "\n\t - MEDIUM" +
                            "\n\t - HIGH");
                    String performanceChosen = input.nextLine().trim();
                    helper.recommendPc(performanceChosen);
                }
                default -> {
                    System.out.println("Invalid command");
                }
            }
        }
        if(finalComputer != null) {
            System.out.println("Your computer is:");
            finalComputer.print();
        }

    }

}
