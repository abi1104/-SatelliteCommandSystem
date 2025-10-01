package Creational.Factory;

public class Main {
    public static void main(String[] args) {
        VendingFactory factory = new VendingFactory();

        VendingMachine item1 = factory.createItem("CoolDrink");
        item1.dispense(); 
        VendingMachine item2 = factory.createItem("Chocolate");
        item2.dispense(); 

        VendingMachine item3 = factory.createItem("Chips");
        item3.dispense(); 
    }
}
