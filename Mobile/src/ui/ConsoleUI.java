package src.ui;

import src.filters.*;
import src.filters.ui.console.*;
import src.products.ProductService;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {
    private final ProductService productService;

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

    public void searchOrders() {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Select Category
        System.out.print("Enter category (Car, Bike, Boat): ");
        String category = scanner.nextLine();

        // Step 2: Validate Category
        if (!productService.validateCategory(category)) {
            System.err.println("Error: Invalid category entered.");
            return;
        }

        // Step 3: Get Filters for Category
        FilterDescriptor filters = productService.getFiltersForCategory(category);

        // Step 4: Collect Inputs for Filters
        for (Map.Entry<String, Filter<?>> entry : filters.getFilters().entrySet()) {
            Filter<?> filter = entry.getValue();
            ConsoleUIFilter<?> uiFilter = getConsoleUIFilterFor(filter);
            uiFilter.collectInput(filter);
        }

        System.out.println("Filters applied successfully.");
    }

    private ConsoleUIFilter<?> getConsoleUIFilterFor(Filter<?> filter) {
        if (filter instanceof ValueFilter) {
            return new ConsoleUIValueFilter();
        } else if (filter instanceof PriceRangeFilter) {
            return new ConsoleUIPriceRangeFilter();
        } else if (filter instanceof DateRangeFilter) {
            return new ConsoleUIDateRangeFilter();
        } else {
            throw new IllegalArgumentException("Unsupported filter type: " + filter.getClass());
        }
    }
}

