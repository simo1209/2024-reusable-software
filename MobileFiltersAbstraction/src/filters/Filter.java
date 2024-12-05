package src.filters;

public interface Filter<T extends Filterable<T>> {
  boolean filter(T obj);
}
