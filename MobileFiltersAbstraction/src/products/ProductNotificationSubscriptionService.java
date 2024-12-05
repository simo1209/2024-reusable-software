package src.products;

import src.notifications.NotificationStrategy;
import src.notifications.NotificationObserver;

public class ProductNotificationSubscriptionService {
    private final ProductService productService;

    public ProductNotificationSubscriptionService(ProductService productService) {
        this.productService = productService;
    }

    public void subscribe(String name, NotificationStrategy strategy) {
        NotificationObserver observer = new NotificationObserver(name, strategy);
        productService.addObserver(observer);
        System.out.println(name + " subscribed for notifications.");
    }

    public void unsubscribe(NotificationObserver observer) {
        productService.removeObserver(observer);
        System.out.println(observer + " unsubscribed from notifications.");
    }
}

