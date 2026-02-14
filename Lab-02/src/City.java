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

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof City)){
            return false;
        }
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString(){
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", timezone='" + timezone + '\'';
    }
}
