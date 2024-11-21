package src.filters;

public abstract class Filter<T> {
    protected final String fieldName;

    public Filter(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public abstract T getFilterValue(); // Value to be used for filtering
}

