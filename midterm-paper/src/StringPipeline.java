import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringPipeline {
    private final List<String> data;

    public StringPipeline(List<String> words){
        this.data = List.copyOf(words);
    }
    public StringPipeline filter(Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for(String word: data){
            if(predicate.test(word)){
                list.add(word);
            }
        }
        return new StringPipeline(list);
    }

    public StringPipeline map(Function<String, String> mapper){
        List<String> list = new ArrayList<>();
        for(String word: data){
            String newValue = mapper.apply(word);
            list.add(newValue);
        }
        return new StringPipeline(list);
    }
    public Optional<String> findFirst(){
        if(data.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(data.get(0));
    }
    public long count(){
        return data.size();
    }
    public List<String> toList(){
        return List.copyOf(data);
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello","hi","hey","howdy","ha");

        // Get words greater than length 2 in uppercase
        List<String> result = new StringPipeline(words)
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .toList();
        System.out.println("Words(len>2) in uppercase Result: ");
        System.out.println(result);

        // Count words (len <= 2) and starts with "h"
        long count = new StringPipeline(words)
                .filter(s->s.startsWith("h"))
                .filter(s -> s.length() <= 2)
                .count();

        System.out.println("\nTotal words len <= and start with 'h' are: " + count);
        // First word starts with "ho"
        Optional<String> first = new StringPipeline(words)
                .filter(s -> s.startsWith("ho"))
                .findFirst();
        System.out.println("\nWord start with 'ho' is:" + first);
    }
}
