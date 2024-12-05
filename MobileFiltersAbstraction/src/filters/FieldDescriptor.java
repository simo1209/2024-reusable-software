package src.filters;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FieldDescriptor<T> {
    protected final Map<String, Function<T, ?>> fieldsExtractors;

    public FieldDescriptor(Map<String, Function<T, ?>> fieldsExtractors) {
      this.fieldsExtractors = fieldsExtractors;
    }

    public Map<String, Function<T, ?>> getFiltersExtractors() {
        return fieldsExtractors;
    }

    public Function<T, ?> getExtractor(String field) {
      return this.getFiltersExtractors().get(field);
    }

    /*
    public void addFilter(String fieldName, Filter<?> filter) {
        filters.put(fieldName, filter);
    }
    */
}

