package Creational.Builder;

// Separate Builder class
public class ComputerBuilder {
    // Default values
    private String CPU = "i3";
    private String RAM = "8GB";
    private String storage = "256GB SSD";
    private String graphicsCard = "Integrated";
    private String operatingSystem = "Windows 10";

    public ComputerBuilder setCPU(String CPU) { this.CPU = CPU; return this; }            
    public ComputerBuilder setRAM(String RAM) { this.RAM = RAM; return this; }            
    public ComputerBuilder setStorage(String storage) { this.storage = storage; return this; } 
    public ComputerBuilder setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; return this; } 
    public ComputerBuilder setOperatingSystem(String os) { this.operatingSystem = os; return this; } 

    // Build method creates immutable Computer
    public Computer build() {                 
        return new Computer(this);           
    }

    // Getters (used by Computer constructor)
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }
}

