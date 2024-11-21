package src.filters.ui.console;

import src.filters.ValueFilter;

import java.util.Scanner;

public class ConsoleUIValueFilter implements ConsoleUIFilter<String> {
    @Override
    public void collectInput(ValueFilter filter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for " + filter.getFieldName() + ": ");
        filter.setValue(scanner.nextLine());
    }
}

