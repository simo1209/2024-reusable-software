package src.filters.ui.console;

import src.filters.PriceRangeFilter;

import java.util.Scanner;

public class ConsoleUIPriceRangeFilter implements ConsoleUIFilter<Double[]> {
    @Override
    public void collectInput(PriceRangeFilter filter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price for " + filter.getFieldName() + ": ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price for " + filter.getFieldName() + ": ");
        double max = scanner.nextDouble();
        filter.setRange(min, max);
    }
}

