import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

//public final class Money {
//    private final double amount;
//    private final String currency;
//    private final Map<String, Double> exchangeRates;
//
//    public Money(double amount, String currency, Map<String, Double> exchangeRates) {
//        this.amount = amount;
//        this.currency = currency;
//        this.exchangeRates = Map.copyOf(exchangeRates);
//    }
//    Optional<Money> convertTo(String targetCurrency){
//        if(!exchangeRates.containsKey(targetCurrency)){
//            return Optional.empty();
//        }
//        double rate = exchangeRates.get(targetCurrency);
//        double updated = amount*rate;
//
//        return Optional.of(new Money(updated, targetCurrency, exchangeRates));
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        if(this == obj){
//            return true;
//        }
//        if(obj == null){
//            return false;
//        }
//        if(!(obj instanceof Money)){
//            return false;
//        }
//        Money other = (Money) obj;
//
//        return Double.compare(this.amount, other.amount) == 0 &&
//                currency.equals(other.currency);
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(amount, currency);
//    }
//
//    @Override
//    public String toString(){
//        return "Money{amount=" + amount + ", currency='" + currency + "'}";
//    }
//
//    public static void main(String[] args) {
//        Map<String, Double> rates = new HashMap<>();
//        rates.put("EUR", 0.92);
//        rates.put("GBP", 0.79);
//
//        Money usd = new Money(100,"USD", rates);
//        Optional<Money> eur =  usd.convertTo("EUR");
//        System.out.println(eur);
//
//        rates.put("JPY", 150.0);
//        System.out.println(usd.convertTo("JPY"));
//
//        Map<Money, String> map = new HashMap<>();
//        Money m1 = new Money(100, "USD", rates);
//        Money m2 = new Money(100,"USD",rates);
//
//        map.put(m1, "Salary");
//        System.out.println(map.get(m2));
//    }
//}




// Functional Style
public final class Money {
    private final double amount;
    private final String currency;
    private final Map<String, Double> exchangeRates;

    public Money(double amount,String currency, Map<String, Double> exchangeRates){
        this.amount = amount;
        this.currency = Objects.requireNonNull(currency);
        this.exchangeRates = Map.copyOf(exchangeRates);
    }
    Optional<Money> convertTo(String targetCurrency){
        return Optional.ofNullable(exchangeRates.get(targetCurrency))
                .map(rate -> new Money(amount*rate,targetCurrency, exchangeRates));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null) return false;
        if (!(obj instanceof Money other)) return false;
        return Double.compare(amount, other.amount) == 0 &&
                currency.equals(other.currency);
    }
    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
    @Override
    public String toString() {
        return "Money{amount=" + amount + ", currency='" + currency + "'}";
    }

    public static void main(String[] args) {
        Map<String, Double> rates = new HashMap<>();
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.79);

        Money usd = new Money(100, "USD", rates);

        System.out.println("Conversion to EUR:");
        usd.convertTo("EUR").ifPresent(System.out::println);

        rates.put("JPY", 150.0);

        System.out.println("\nTrying conversion to JPY after modifying map:");
        System.out.println(usd.convertTo("JPY"));

        Map<Money, String> salaryMap = new HashMap<>();
        Money m1 = new Money(100, "USD", rates);
        Money m2 = new Money(100, "USD", rates);

        salaryMap.put(m1, "Salary");
        System.out.println("\nHashMap retrieval with equal object:");
        System.out.println(salaryMap.get(m2));
    }
}
