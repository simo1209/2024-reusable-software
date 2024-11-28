package src.products;

import src.filters.FieldDescriptor;
import src.filters.Filterable;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class Bike extends Filterable<Bike> {
  private long price;
  private String brand;
  private long gearCount;
  private String model;

  public Bike(long price, String brand, long gearCount, String model) {
    this.price = price;
    this.brand = brand;
    this.gearCount = gearCount;
    this.model = model;

    Map<String, Function<Bike, ?>> fieldDescriptorMap = new HashMap<>();
    fieldDescriptorMap.put("price", Bike::getPrice);
    fieldDescriptorMap.put("brand", Bike::getBrand);
  }

  public long getPrice() {
    return this.price;
  }

  public String getBrand() {
    return this.brand;
  }

  public long getGearCount() {
    return this.gearCount;
  }

  public String getModel() {
    return this.model;
  }


}
