class SmsSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("sending SMS: " + message);
    }
}