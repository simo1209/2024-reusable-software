package mobile.search;

import java.util.List;

public class ThreshHoldFilter<T> implements Filter<T> {
    private final List<Filter<T>> filters;
    private final int threshold;

    public ThreshHoldFilter(List<Filter<T>> filters, int threshold) {
        if (threshold < 1 || threshold > filters.size()) {
            throw new IllegalArgumentException("Threshold must be between 1 and the number of filters.");
        }
        this.filters = filters;
        this.threshold = threshold;
    }

    @Override
    public boolean matches(T item) {
        int matchCount = 0;
        for (Filter<T> filter : filters) {
            if (filter.matches(item)) {
                matchCount++;
                if (matchCount >= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
