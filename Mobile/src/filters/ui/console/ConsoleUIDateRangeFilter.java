package src.filters.ui.console;

import src.filters.DateRangeFilter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUIDateRangeFilter implements ConsoleUIFilter<LocalDate[]> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void collectInput(DateRangeFilter filter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start date (yyyy-MM-dd) for " + filter.getFieldName() + ": ");
        LocalDate start = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Enter end date (yyyy-MM-dd) for " + filter.getFieldName() + ": ");
        LocalDate end = LocalDate.parse(scanner.nextLine(), formatter);
        filter.setRange(start, end);
    }
}

