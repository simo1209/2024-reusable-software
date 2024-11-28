package src.filters;

import java.util.Map;
import java.util.function.Function;

public class Filterable<T extends Filterable<T>> {
  protected Map<String, Function<T, ?>> fieldDescriptorMap;

  public FieldDescriptor<T> getFieldDescriptor() {
    return new FieldDescriptor<>(this.fieldDescriptorMap);
  }
}
