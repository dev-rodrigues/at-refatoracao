package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};

    private final String name;
    private final List<CountryDriver> results;
    private final Map<CountryDriver, String> driverNames;

    public Race(String name, CountryDriver... countryDrivers) {
        this.name = name;
        this.results = Arrays.asList(countryDrivers);
        this.driverNames = new HashMap<>();
        for (CountryDriver countryDriver : results) {
            String driverName = countryDriver.getName();
            this.driverNames.put(countryDriver, driverName);
        }
    }

    public int position(CountryDriver countryDriver) {
        return this.results.indexOf(countryDriver);
    }

    public int getPoints(CountryDriver countryDriver) {
        return Race.POINTS[position(countryDriver)];
    }

    public List<CountryDriver> getResults() {
        return results;
    }

    public String getDriverName(CountryDriver countryDriver) {
        return this.driverNames.get(countryDriver);
    }

    @Override
    public String toString() {
        return name;
    }
}
