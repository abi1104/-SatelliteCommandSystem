package Creational.Factory;

public class Main {
    public static void main(String[] args) {
        VendingFactory factory = new VendingFactory();

        VendingMachine item1 = factory.createItem("CoolDrink");
        item1.dispense(); // Output: Dispensing Tea...
        VendingMachine item2 = factory.createItem("Chocolate");
        item2.dispense(); // Output: Dispensing Chocolate...

        //VendingMachine item3 = factory.createItem("Chips");
        //item3.dispense(); // Output: Dispensing Chips...
    }
}
