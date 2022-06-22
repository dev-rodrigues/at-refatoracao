package tddmicroexercises.leaderboard;

public class CountryDriver implements Driver {
    private final String name;
    private final String country;

    public CountryDriver(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryDriver)) {
            return false;
        }
        CountryDriver other = (CountryDriver) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }
}
