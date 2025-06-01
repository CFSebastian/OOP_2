# OPP 2 Project

## Introduction   
My project is a terminal app that helps you build a personal computer, and is more inclined towards gaming computers. 
I also added an admin interface to simulate the CRUD activity of four components, it does not let you add and update   
with new data, instead it uses recreated objects. And there is also an Audit service with a methode that writes in .txt   
file.

## Packages classes  
**project**:  
- Main - in main is the primary loop of the application  
- Computer -  a class witch contains the components and some methods to verify and gain details about an object  
- PCBuilder - a builder design pattern to build Computer objects  
- PcComponentNotFound - Error when a components are not where it is presumed to be by the user  
- PcBro - a service class to help the user work with the different objects  
- components - package that contains all classes associated with the Components abstract class  
- README.md - documentation  

**components**:  
-Components - abstract class that contains the attributes and methods common between its children  
-Case    
-GraphicsCard   
-Processor  
-RAM   
-Motherboard    
-Storage   
-PowerSupply   

**components - part 2**:
-ConnectionProvider
-repository classes (repositories for 4 components)
-service classes (services for 4 components and an Audit class for audit)
-Admin class - for interacting with CRUD actions

## Actions   
### Part 1
**Components:**  
-print() - prints the details of a component or just the name and price if not overridden  
-type() - returns type of component to differentiate between them  

**Computer:**  
-calculatePowerConsumption() - returns the amount of power that is left from the power supply  
-verifyCompatibilityBetweenRams() - verifies if a ram sticks is not decreasing the performance of other sticks  
-verifyCompatibility () - verifies if the components are compatible  
-classifyPC() -  classifies the pc in one of three categories of price  
-pcPrice() - returns the price of the pc  
-print() - prints the basic details of the pc, i.e. the names of most components and the total memory of the storage and ram  

**PcBro**  
-addComponent(Component component) - use inside the code to easily add components  
-addComputer(Computer computer)  - use inside the code to easily add computers  
-selectComponent(String type) - prompts the user to select a type of component from a list  
-buildPc() - helps the user build the pc and verify the components compatibility, gives suggestions and rates said pc at the  
-recommendPc(String performance) - recommends a list( that is sorted from cheapest to expensive) of computers depending on the performance that the user is searching  
-selectPc() -  list all the computers in the memory and prompts the user to select his choice  
-getComponentListOf(String type) -  gets a list of components depending on what type is selected  

### Part 2
**Repositories**  
Functions for insert, update, select after partial name and delete functions

**services for components**  
Functions for insert, update, select after partial name and delete functions

**Audit service**
-addToAudit() - function to write in files/audit.txt when a user selects one of the actions possible in the primary menu and saves the current date and time at witch the action occurred

**Admin**
Diverse function to test the CRUD functions from services for the 4 components that have tables in the DB