package src.products.filter_descriptors;

import src.filters.*;

public class BikeFilterDescriptor extends FilterDescriptor {
    public BikeFilterDescriptor() {
        addFilter("price", new PriceRangeFilter("price"));
        addFilter("brand", new ValueFilter("brand"));
        addFilter("gearCount", new ValueFilter("gearCount"));
        addFilter("model", new ValueFilter("model"));
    }
}

