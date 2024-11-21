package src.filters.ui.console;

import src.filters.Filter;

public interface ConsoleUIFilter<T> {
    void collectInput(Filter<T> filter);
}

