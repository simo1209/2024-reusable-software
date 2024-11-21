package src.products;

import src.filters.FilterDescriptor;
import src.products.filter_descriptors.*;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private final Map<String, FilterDescriptor> categoryFilters = new HashMap<>();

    public ProductService() {
        categoryFilters.put("Car", new CarFilterDescriptor());
        categoryFilters.put("Bike", new BikeFilterDescriptor());
        categoryFilters.put("Boat", new BoatFilterDescriptor());
    }

    public FilterDescriptor getFiltersForCategory(String category) {
        return categoryFilters.get(category);
    }

    public boolean validateCategory(String category) {
        return categoryFilters.containsKey(category);
    }
}

