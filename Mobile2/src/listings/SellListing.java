package src.listings;

public record SellListing extends Listing (
    Double price, 

    Product product
) {};
