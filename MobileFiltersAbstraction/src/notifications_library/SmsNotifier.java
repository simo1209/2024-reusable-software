package src.notifications_library;

public class SmsNotifier {
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message);
    }
}
