package mobile.search;

public class LessThanFilter<T, V extends Comparable<V>> implements Filter<T> {
    private final FieldExtractor<T, V> fieldExtractor;
    private final V max;

    public LessThanFilter(FieldExtractor<T, V> fieldExtractor, V max) {
        this.fieldExtractor = fieldExtractor;
        this.max = max;
    }

    @Override
    public boolean matches(T item) {
        V value = fieldExtractor.extractValue(item);
        return value.compareTo(max) < 0;
    }
}
