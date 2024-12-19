package mobile.notifications;

import mobile.listings.Listing;
import mobile.notifications.channels.NotificationChannel;
import mobile.search.Filter;

public record NotificationRule(
    Filter<Listing> filter,
    NotificationChannel channel
) {}
