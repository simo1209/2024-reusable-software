package src.products.filter_descriptors;

import src.filters.*;

public class BoatFilterDescriptor extends FilterDescriptor {
    public BoatFilterDescriptor() {
        addFilter("make", new ValueFilter("make"));
        addFilter("length", new ValueFilter("length"));
        addFilter("year", new ValueFilter("year"));
    }
}

