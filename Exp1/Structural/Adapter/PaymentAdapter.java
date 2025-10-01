package Structural.Adapter;

public class PaymentAdapter implements NewPaymentGateway {
    private OldPaymentSystem oldSystem;

    public PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }
    public void makePayment(double amount) {
        int roundedAmount = (int) amount;
        oldSystem.payAmount(roundedAmount);
    }
}
