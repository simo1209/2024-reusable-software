package mobile.parser;

import mobile.search.*;
import java.util.*;

public class FilterBuilder<T> {

    private final Map<String, FieldExtractor<T, ?>> fieldExtractors;

    public FilterBuilder(Map<String, FieldExtractor<T, ?>> fieldExtractors) {
        this.fieldExtractors = fieldExtractors;
    }

    public Filter<T> buildFilter(List<String> tokens) {
        Iterator<String> iterator = tokens.iterator();
        return buildFilterHelper(iterator);
    }

    private Filter<T> buildFilterHelper(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Invalid Polish notation input");
        }

        String token = iterator.next();

        switch (token) {
            case "&":
                return buildAndFilter(iterator);
            case "|":
                return buildOrFilter(iterator);
            case "=":
                return buildExactValueFilter(iterator);
            case ">":
                return buildMoreThanFilter(iterator);
            case "<":
                return buildLessThanFilter(iterator);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + token);
        }
    }

    private <V extends Comparable<V>> Filter<T> buildLessThanFilter(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a max value after '<' operator");
        }
        String max = iterator.next();

        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a field name after max value");
        }
        String fieldName = iterator.next();

        @SuppressWarnings("unchecked")
        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) fieldExtractors.get(fieldName);
        if (fieldExtractor == null) {
            throw new IllegalArgumentException("No field extractor defined for field: " + fieldName);
        }

        return new LessThanFilter<>(fieldExtractor, parseValue(max));
    }

    private <V extends Comparable<V>> Filter<T> buildMoreThanFilter(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a min value after '>' operator");
        }
        String min = iterator.next();

        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a field name after min value");
        }
        String fieldName = iterator.next();

        @SuppressWarnings("unchecked")
        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) fieldExtractors.get(fieldName);
        if (fieldExtractor == null) {
            throw new IllegalArgumentException("No field extractor defined for field: " + fieldName);
        }

        return new MoreThanFilter<>(fieldExtractor, parseValue(min));
    }

    private Filter<T> buildAndFilter(Iterator<String> iterator) {
        List<Filter<T>> filters = new ArrayList<>();
        filters.add(buildFilterHelper(iterator));
        filters.add(buildFilterHelper(iterator));
        return new AndFilter<>(filters);
    }

    private Filter<T> buildOrFilter(Iterator<String> iterator) {
        List<Filter<T>> filters = new ArrayList<>();
        filters.add(buildFilterHelper(iterator));
        filters.add(buildFilterHelper(iterator));
        return new OrFilter<>(filters);
    }

    private <V> Filter<T> buildExactValueFilter(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a value after '=' operator");
        }
        String value = iterator.next();

        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expected a field name after value");
        }
        String fieldName = iterator.next();

        @SuppressWarnings("unchecked")
        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) fieldExtractors.get(fieldName);
        if (fieldExtractor == null) {
            throw new IllegalArgumentException("No field extractor defined for field: " + fieldName);
        }

        return new ExactValueFilter<>(fieldExtractor, parseValue(value));
    }

    @SuppressWarnings("unchecked")
    private <V> V parseValue(String value) {
        // Simplified parsing logic; adjust as needed for your data
        if (value.startsWith("'") && value.endsWith("'")) {
            return (V) value.substring(1, value.length() - 1);
        }
        try {
            return (V) Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return (V) value;
        }
    }
}
