package mobile;

import mobile.search.CaseInsensitiveFilter;
import mobile.search.ExactValueFilter;
import mobile.search.Filter;
import mobile.search.AndFilter;
import mobile.search.OrFilter;
import mobile.search.RangeFilter;
import mobile.vehicles.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2021, true);
        Car car2 = new Car("Bmw", "e60", 2000, false);
        Car car3 = new Car("Audi", "r8", 2024, false);


        // всичките хиляди коли които имаме
        List<Car> cars = List.of(car, car2,car3);

        List<Filter<Car>> filters = List.of(
            new ExactValueFilter<>(Car::brand, "Toyota"),
            new CaseInsensitiveFilter<>(Car::model, "Corolla"),
            new RangeFilter<>(Car::year, 2000, 2022),
            new RangeFilter<>(Car::brand, "Bmw", "Toyota")
        );

        // само колите от филтрите
        List<Car> matchingCars = filterCars(cars, filters);
        System.out.println("Matching cars:");
        matchingCars.forEach(System.out::println);

        System.out.println("Composite filter:");

        Filter<Car> bmwFilters = new AndFilter<>(List.of(
            new ExactValueFilter<>(Car::brand, "Bmw")
        ));
        Filter<Car> audiFilters = new AndFilter<>(List.of(
            new ExactValueFilter<>(Car::brand, "Audi")
        ));

        Filter<Car> bmwOrAudiFilters = new OrFilter<>(List.of(bmwFilters, audiFilters));
        List<Car> matchingCars2 = filterCars(cars, List.of(bmwOrAudiFilters));
        matchingCars2.forEach(System.out::println);

    }

    // не му е мястото тук, само за демонстративни цели е
    private static List<Car> filterCars(List<Car> cars, List<Filter<Car>> filters) {
        return cars.stream()
            .filter(car -> filters.stream().allMatch(filter -> filter.matches(car)))
            .toList();
    }
}
