package mobile.search;

public class MoreThanFilter<T, V extends Comparable<V>> implements Filter<T> {
    private final FieldExtractor<T, V> fieldExtractor;
    private final V min;

    public MoreThanFilter(FieldExtractor<T, V> fieldExtractor, V min) {
        this.fieldExtractor = fieldExtractor;
        this.min = min;
    }

    @Override
    public boolean matches(T item) {
        V value = fieldExtractor.extractValue(item);
        return value.compareTo(min) > 0;
    }
}
