package src.filters;

public interface Filter<T extends Filterable, R> {
  boolean filter(T obj);
}
