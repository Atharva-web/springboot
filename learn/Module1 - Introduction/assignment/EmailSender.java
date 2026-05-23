class EmailSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.print("sending EMAIL: " + message);
    }
}