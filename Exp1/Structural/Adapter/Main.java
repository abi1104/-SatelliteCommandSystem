package Structural.Adapter;

public class Main {
    public static void main(String[] args) {
        // Old system object
        OldPaymentSystem oldPayment = new OldPaymentSystem();

        // Use adapter to connect with new gateway interface
        NewPaymentGateway paymentGateway = new PaymentAdapter(oldPayment);

        // Client thinks it's using new system
        paymentGateway.makePayment(999.75);
    }
}
