package src.listings;

public record Listing(
    String description,
    String title,
    bool isActive,
    bool isSponsored,

    LocalDate createdAt,
    Creator creator,
) {};

public record Creator (
    String firstName,
    String lastName,
    String phoneNumber,
    City city
) {};

