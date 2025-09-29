package Structural.Adapter;

public class PaymentAdapter implements NewPaymentGateway {
    private OldPaymentSystem oldSystem;

    public PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void makePayment(double amount) {
        // Convert double to int for old system
        int roundedAmount = (int) amount;
        oldSystem.payAmount(roundedAmount);
    }
}
