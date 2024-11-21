package src.filters;

import java.time.LocalDate;

public class DateRangeFilter extends RangeFilter<LocalDate> {
    public DateRangeFilter(String fieldName) {
        super(fieldName);
    }
}

