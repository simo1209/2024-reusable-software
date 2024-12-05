package src.filters;

import java.util.function.Function;

public class ExactFilter<T extends Filterable<T>, V> implements Filter<T> {

  private String field;
  private V value;

  public ExactFilter(String field, V value) {
    this.field = field;
    this.value = value;
  } 

  public boolean filter(T obj) {
    FieldDescriptor<T> filterDescriptor = obj.getFieldDescriptor();
    Function<T, ?> fieldExtractor = filterDescriptor.getExtractor(field); 

    return fieldExtractor.apply(obj) == value;
  }

}
