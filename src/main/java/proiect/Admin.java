package main.java.proiect;

import main.java.proiect.components.*;
import main.java.proiect.exceptions.GraphicsCardNotFound;
import main.java.proiect.exceptions.ProcessorNotFound;
import main.java.proiect.exceptions.RamNotFound;
import main.java.proiect.exceptions.StorageNotFound;
import main.java.proiect.services.GraphicsCardService;
import main.java.proiect.services.ProcessorService;
import main.java.proiect.services.RamService;
import main.java.proiect.services.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private static Admin instance;
    private GraphicsCardService graphicsCardService = new GraphicsCardService();
    private ProcessorService processorService = new ProcessorService();
    private RamService ramService = new RamService();
    private StorageService storageService = new StorageService();

    private Scanner input = new Scanner(System.in);
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    private  Admin() {}
    public void addComponent() {
        System.out.print("Enter component type(cpu,gpu,ram,storage) to add:");
        String command = input.nextLine();
        switch (command) {
            case "cpu" -> {
                processorService.insertData(new Processor("In cpu",2,2,2,2,"old"));
            }
            case "gpu" -> {
                graphicsCardService.insertData(new GraphicsCard("In gpu",2,2,2));
            }
            case "ram" -> {
                ramService.insertData(new RAM("In RAM",2,2,2,"ddr1"));
            }
            case "storage" -> {
                storageService.insertData( new Storage("In SSd",2,2));
            }
        }
    }


    public void removeComponent() {
        System.out.print("Enter component type(cpu,gpu,ram,storage) to remove:");
        String command = input.nextLine();
        switch (command) {
            case "cpu" -> {
                System.out.println("Enter cpu id:");
                Long id = input.nextLong();
                processorService.deleteProcessor(id);
            }
            case "gpu" -> {
                System.out.println("Enter gpu id:");
                Long id = input.nextLong();
                graphicsCardService.deleteGraphicsCard(id);
            }
            case "ram" -> {
                System.out.println("Enter ram id:");
                Long id = input.nextLong();
                ramService.deleteRam(id);
            }
            case "storage" -> {
                System.out.println("Enter storage id:");
                Long id = input.nextLong();
                storageService.deleteStorage(id);
            }
        }

    }

    public void getComponents() {
        System.out.println("Search component partial name:");
        String name = input.nextLine().trim();
        List<Component> results = new ArrayList<>();
        try {
            results.addAll(processorService.getProcessorByName(name));
        } catch (ProcessorNotFound e) {
            System.err.println("Processor list "+name + " is " + e.getMessage());
        }
        try {
            results.addAll(graphicsCardService.getGraphicsCardByName(name));
        } catch (GraphicsCardNotFound e) {
            System.err.println("Graphics Card listfor "+name+" is " + e.getMessage());
        }
        try {
            results.addAll(storageService.getStorageByName(name));
        } catch (StorageNotFound e) {
            System.err.println("Storage list for "+name+" is " + e.getMessage());
        }
        try {
            results.addAll(ramService.getRamByName(name));
        } catch (RamNotFound e) {
            System.err.println("Ram list "+name+" is " + e.getMessage());
        }




        for (Component component : results) {
            System.out.println(component.toString());
        }
    }

    public  void updateComponent() {
        System.out.print("Enter component type(cpu,gpu,ram,storage) to update:");
        String command = input.nextLine();
        switch (command) {
            case "cpu" -> {
                System.out.println("Enter cpu id:");
                Long id = input.nextLong();
                processorService.updateProcessor(id,new Processor("Update cpu",1,1,1,1,"new"));
            }
            case "gpu" -> {
                System.out.println("Enter gpu id:");
                Long id = input.nextLong();
                graphicsCardService.updateGraphicsCard(id,new GraphicsCard("Update gpu",1,1,1));
            }
            case "ram" -> {
                System.out.println("Enter ram id:");
                Long id = input.nextLong();
                ramService.updateRam(id,new RAM("Up RAM",1,1,1,"ddr5"));
            }
            case "storage" -> {
                System.out.println("Enter storage id:");
                Long id = input.nextLong();
                storageService.updateStorage(id, new Storage("Up SSd",1,1));
            }
        }
    }
}
