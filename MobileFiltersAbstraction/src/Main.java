package src;

import src.notifications_library.EmailNotifier;

import src.products.Bike;
import src.products.ProductService;
import src.products.ProductNotificationSubscriptionService;
import src.notifications.EmailNotification;

public class Main {
  public static void main(String[] args) {
    Bike bike = new Bike(100, "brand kolelo", 6, "model kolelo");

    EmailNotifier emailNotifier = new EmailNotifier();

    // Create the ProductService
    ProductService productService = new ProductService();

    // Create the Subscription Service
    ProductNotificationSubscriptionService subscriptionService =
      new ProductNotificationSubscriptionService(productService);

    // Subscribe users with different notification strategies
    subscriptionService.subscribe("Alice", new EmailNotification(emailNotifier, "koleto@abv.bg", "Product Subscription"));
  }
}
