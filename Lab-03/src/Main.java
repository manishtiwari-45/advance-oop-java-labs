import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer,Integer> ladders = new HashMap<>();

        snakes.put(16,6);
        snakes.put(47,26);
        snakes.put(49,11);
        snakes.put(56,53);
        snakes.put(62,19);
        snakes.put(64,60);
        snakes.put(87,24);
        snakes.put(93,73);
        snakes.put(98,78);

        ladders.put(1,38);
        ladders.put(4,14);
        ladders.put(9,31);
        ladders.put(21,42);
        ladders.put(28,84);
        ladders.put(36,44);
        ladders.put(51,67);
        ladders.put(71,91);
        ladders.put(80,100);

        SnackLadderGame game = new SnackLadderGame(snakes,ladders);
//        int minRolls = game.findMinRolls();
//        System.out.println("Minimum rolls are:" + minRolls);

        Optional<String> winner = game.simulateGame(3);
        winner.ifPresent(w -> System.out.println("Winner is: " + w));
    }
}






