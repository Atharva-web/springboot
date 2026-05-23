public class NotificationTester {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new SmsSender());
        notificationService.sendNotification("Your order is confirmed");
    }
}