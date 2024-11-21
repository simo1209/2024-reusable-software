package src.filters;

public abstract class RangeFilter<T extends Comparable<T>> extends Filter<T[]> {
    protected T minValue;
    protected T maxValue;

    public RangeFilter(String fieldName) {
        super(fieldName);
    }

    public void setRange(T minValue, T maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public T[] getFilterValue() {
        return (T[]) new Comparable[]{minValue, maxValue};
    }
}

