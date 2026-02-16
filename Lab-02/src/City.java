import java.util.Objects;

public final class City {

    private final String name;
    private final String country;
    private final String timezone;

    public City(String name, String country, String timezone) {

        this.name = name;
        this.country = country;
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public String getTimezone() {
        return timezone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City other = (City) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "City{name='" + name + "', country='" + country +
                "', timezone='" + timezone + "'}";
    }
}
