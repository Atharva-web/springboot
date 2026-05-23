class UPIPayment implements PaymentMethod {
    public void pay(Double amount) {
        System.out.println("Processing payment of " + amount + " via UPI\n");
    }
}