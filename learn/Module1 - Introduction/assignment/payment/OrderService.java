import java.util.Scanner;

public class OrderService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(".....");
        System.out.println("choose a payment method");
        System.out.println("1. Credit card");
        System.out.println("2. UPI");

        String choice = sc.next();
        sc.close();

        PaymentProcessor paymentProcessor = null;
        if(choice.equals("1")) {
            paymentProcessor = new PaymentProcessor(new CreditCardPayment());
        }
        else if(choice.equals("2")) {
            paymentProcessor = new PaymentProcessor(new UPIPayment());
        }

        paymentProcessor.processPayment(500d);
    }
}