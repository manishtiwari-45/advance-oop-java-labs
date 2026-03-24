import java.util.List;

public class MyNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3,-1,2,3,-5,7,2,8,-1,7);

        List<Integer>  result = numbers.stream()
                .filter(n -> n>0)
                .distinct()
                .sorted()
                .map(n -> n*n)
                .toList();

        System.out.println(result);
    }
}
