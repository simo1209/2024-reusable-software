package mobile.parser;

import mobile.listings.Listing;
import mobile.search.FieldExtractor;
import mobile.search.Filter;
import mobile.vehicles.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuerySearcher implements Searcher{
    @Override
    public List<Listing> search(List<Listing> listings, String query) {
        QueryParser parser = new QueryParser();
        List<String> tokens = parser.toPolishNotation(query);

        Map<String, FieldExtractor<Car, ?>> fieldExtractors = new HashMap<>();
        fieldExtractors.put("year", Car::year);
        fieldExtractors.put("model", Car::model);
        fieldExtractors.put("brand", Car::brand);

        FilterBuilder<Car> builder = new FilterBuilder<>(fieldExtractors);
        Filter<Car> filter = builder.buildFilter(tokens);

        return listings.stream()
                .filter(listing -> filter.matches(listing.getCar()))
                .toList();
    }
}
