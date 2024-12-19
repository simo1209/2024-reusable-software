package mobile.notifications;

import mobile.listings.Listing;
import mobile.search.Filter;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<NotificationRule> notificationRules = new ArrayList<>();

    public void subscribe(NotificationRule notificationRule) {
        notificationRules.add(notificationRule);
    }

    public void onNewListingAdded(Listing listing) {
        for (NotificationRule notificationRule : notificationRules) {
            if (notificationRule.filter().matches(listing)) {
                String message = listing.getCar().brand() + " "
                    + listing.getCar().model() +
                    " for " + listing.getPrice();
                notificationRule.channel().notify(
                    "New car found for you!",
                    message
                );
            }
        }
    }
}
