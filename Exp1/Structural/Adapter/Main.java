package Structural.Adapter;

public class Main {
    public static void main(String[] args) {
        OldPaymentSystem oldPayment = new OldPaymentSystem();

        NewPaymentGateway paymentGateway = new PaymentAdapter(oldPayment);

        paymentGateway.makePayment(999.75);
    }
}
