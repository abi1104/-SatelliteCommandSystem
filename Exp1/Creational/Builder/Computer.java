package Creational.Builder;

// Product: immutable Computer
public final class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;

    // Private constructor: Only Builder can call this
    Computer(ComputerBuilder builder) {                
        this.CPU = builder.getCPU();                       
        this.RAM = builder.getRAM();                       
        this.storage = builder.getStorage();               
        this.graphicsCard = builder.getGraphicsCard();     
        this.operatingSystem = builder.getOperatingSystem(); 
    }

    // Display the configuration
    public void displayConfig() {               
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("---------------------------------");
    }
}
