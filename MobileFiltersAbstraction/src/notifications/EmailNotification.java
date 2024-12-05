package src.notifications;

import src.notifications_library.EmailNotifier;

public class EmailNotification implements NotificationStrategy {

    private EmailNotifier emailNotifier;
    private String email;
    private String title;

    public EmailNotification(EmailNotifier emailNotifier, String email, String title) {
      this.emailNotifier = emailNotifier;
      this.email = email;
      this.title = title;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email Notification: " + message);
        emailNotifier.sendEmail(this.email, this.title, message);
    }
}
