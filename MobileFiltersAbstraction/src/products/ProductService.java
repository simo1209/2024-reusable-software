package src.products;

import java.util.ArrayList;
import java.util.List;

import src.notifications.NotificationObserver;

public class ProductService {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void createBike(Bike bike) {
        notifyObservers(bike.getModel());
        // this.productRepository.saveBike(bike);
    }

    private void notifyObservers(String productName) {
        for (NotificationObserver observer : observers) {
            observer.notify(productName);
        }
    }
}
