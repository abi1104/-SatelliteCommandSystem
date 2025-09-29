package Creational.Builder;

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new ComputerBuilder()
                                .setCPU("Intel i9")
                                .setRAM("32GB")
                                .setStorage("1TB SSD")
                                .setGraphicsCard("NVIDIA RTX 4090")
                                .setOperatingSystem("Windows 11 Pro")
                                .build();

        Computer officePC = new ComputerBuilder()
                                .setCPU("Intel i5")
                                .setRAM("16GB")
                                .setStorage("512GB SSD")
                                .setGraphicsCard("Integrated")
                                .setOperatingSystem("Windows 11 Home")
                                .build();

        gamingPC.displayConfig();
        officePC.displayConfig();
    }
}

