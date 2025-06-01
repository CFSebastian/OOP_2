package main.java.proiect;


import main.java.proiect.components.*;
import main.java.proiect.components.Component;
import main.java.proiect.services.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        GraphicsCardService graphicsCardService = new GraphicsCardService();
        ProcessorService processorService = new ProcessorService();
        RamService ramService = new RamService();
        StorageService storageService = new StorageService();

        TreeMap<String,Integer> ports = new TreeMap<>();

        String[][] portType = new String[][]{{"USB3.0","2"},{"USB2.0","3"},{"USB-C","1"},{"JACK","1"}};

        //processorService.insertData(new Processor("Ryzen5 5600X",23,6,3.7f,88,"AM4"));
        //processorService.insertData(new Processor("Ryzen5 5600",400,6,3.5f,88,"AM4"));
        //processorService.insertData(new Processor("Ryzen5 5500",300,6,3.6f,65,"AM4"));
       // graphicsCardService.insertData(new GraphicsCard("Radeon RX 6700XT",23,12,230));
       // ramService.insertData(new RAM("FVulcan",23,8,3200,"DDR4"));
        //storageService.insertData(new Storage("Adata",23,1000));

       // processorService.deleteProcessor(processorService.getProcessorByName("Ryzen5 5600X").getFirst().getId());
        //graphicsCardService.deleteGraphicsCard(graphicsCardService.getGraphicsCardByName("Radeon RX 6700XT").getFirst().getId());

       // processorService.insertData(new Processor("Ryzen5 5600X",470,6,3.7f,88,"AM4"));
        //graphicsCardService.insertData(new GraphicsCard("Radeon RX 6700XT",1200,12,230));

       // ramService.updateRam(ramService.getRamByName("FVulcan").getFirst().getId(),new RAM("FVulcan",100,8,3200,"DDR4"));
        storageService.updateStorage(storageService.getStorageByName("Adata").getFirst().getId(),new Storage("Adata",200,1000));

        for (int i=0;i<portType.length;i++) {
            ports.put(portType[i][0],Integer.parseInt(portType[i][1]));
        }

        Component[] components = new Component[]{
                new Motherboard(4,"B550 Gaming X V2",200,"ATX","AM4","DDR4",ports),
                new PowerSupply(6,"BP750",400,"Gold",750),
                new Case(7,"Case",100,"ATX"),
                processorService.getProcessorByName("Ryzen5 5600X").getFirst(),
                graphicsCardService.getGraphicsCardByName("Radeon RX 6700XT").getFirst(),
                ramService.getRamByName("FVulcan").getFirst(),
                storageService.getStorageByName("Adata").getFirst(),
        };

        Scanner input = new Scanner(System.in);

        Computer finalComputer =null;

        PcBro helper = PcBro.getInstance();
        for(Component component : components) {
            helper.addComponent(component);
        }

        boolean appOn = true;

        Admin admin1 = Admin.getInstance();

        while(appOn){
            System.out.print("""
                    Possible commands:
                    exit ; build pc ; recommend pc ; select a pc ; view components
                    add ; delete ; select ; update
                    Enter command:
                    """);
            String command = input.nextLine().trim();
            switch (command) {
                case "exit" -> {
                    appOn = false;
                    Audit.addToAudit("Exit");
                }
                case "build pc" -> {
                    helper.buildPc();
                    Audit.addToAudit("Build Pc");
                }
                case "select a pc" -> {
                    finalComputer = helper.selectPc();
                    Audit.addToAudit("Select final Pc");
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
                    Audit.addToAudit("Select Component Type: " + componentType);
                }
                case "recommend pc" -> {
                    System.out.println("Enter the performance that you are looking for. You can select the following:" +
                            "\n\t - All" +
                            "\n\t - LOW" +
                            "\n\t - MEDIUM" +
                            "\n\t - HIGH");
                    String performanceChosen = input.nextLine().trim();
                    helper.recommendPc(performanceChosen);
                    Audit.addToAudit("Recommend pc with performance: " + performanceChosen);
                }
                /*#######################################################################################*/
                case "add" -> {
                    admin1.addComponent();
                    Audit.addToAudit("Add Component");
                }
                case "delete" -> {
                    admin1.removeComponent();
                    Audit.addToAudit("Remove Component");
                }
                case "select" -> {
                    admin1.getComponents();
                    Audit.addToAudit("Select Component");
                }
                case "update" -> {
                    admin1.updateComponent();
                    Audit.addToAudit("Update Component");
                }
                default -> {
                    System.out.println("Invalid command");
                    Audit.addToAudit("Invalid command");
                }
            }
        }
        if(finalComputer != null) {
            System.out.println("Your computer is:");
            finalComputer.print();
        }

    }

}
