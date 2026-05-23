class CreditCardPayment implements PaymentMethod {
    public void pay(Double amount) {
        System.out.println("Processing payment of " + amount + " via Credit Card\n");
    }
}

// taking ownership of its methods