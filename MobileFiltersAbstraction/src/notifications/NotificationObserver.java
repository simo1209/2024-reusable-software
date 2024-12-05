package src.notifications;

public class NotificationObserver {
    private final String name;
    private final NotificationStrategy notificationStrategy;

    public NotificationObserver(String name, NotificationStrategy notificationStrategy) {
        this.name = name;
        this.notificationStrategy = notificationStrategy;
    }

    public void notify(String productName) {
        String message = "Hello " + name + ", a new product has been added: " + productName;
        notificationStrategy.sendNotification(message);
    }
}

