package Creational.Factory;
public class VendingFactory {
    public VendingMachine createItem(String type) {
        if(type.equalsIgnoreCase("CoolDrink")) return new CoolDrink();
        else if(type.equalsIgnoreCase("Chocolate")) return new Chocolate();
        else if(type.equalsIgnoreCase("Chips")) return new Chips();
        return null;
    }
}
