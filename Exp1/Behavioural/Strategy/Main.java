package Behavioural.Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.payAmount(500);

        context.setPaymentStrategy(new PayPalPayment());
        context.payAmount(1200);

        context.setPaymentStrategy(new UPIPayment());
        context.payAmount(300);
    }
}

