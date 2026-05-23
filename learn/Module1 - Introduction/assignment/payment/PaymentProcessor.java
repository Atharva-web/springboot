class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(Double amount) {
        paymentMethod.pay(amount);
        System.out.println("Payment processed successfully.");
    }
}

// the objective of this class is to process payments using a payment method
// which payment method is not its concern