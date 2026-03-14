import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

class IntPair {
    private int first;
    private int second;

    public IntPair(int f, int s){
        this.first = f;
        this.second = s;
    }
    public int getSecond() {
        return second;
    }
    public int getFirst() {
        return first;
    }
}

public class SnackLadderGame {
    private final Map<Integer, List<Integer>> board;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public SnackLadderGame(Map<Integer,Integer> snakes, Map<Integer, Integer> ladders){
        this.snakes = Map.copyOf(snakes);
        this.ladders = Map.copyOf(ladders);
        if(!validateBoard()){
            throw new IllegalArgumentException("Invalid Board Configuration");
        }
        this.board = new HashMap<>();
        buildBoard();
    }
    public void buildBoard(){
        for(int square = 1; square <= 100; square++){
            List<Integer> list = new ArrayList<>();
            for(int i = 1;i <= 6; i++){
                int curr = square + i;
                if(curr > 100){
                    break;
                }
                list.add(curr);
            }
            board.put(square, list);
        }
    }
    public Optional<Integer> getJumpDestination(int square){
        if(snakes.containsKey(square)){
            return Optional.of(snakes.get(square));
        } else if(ladders.containsKey(square)){
            return Optional.of(ladders.get(square));
        } else{
            return Optional.empty();
        }
    }
    public boolean validateBoard(){
        Stream<Map.Entry<Integer, Integer>> snackStream = snakes
                .entrySet()
                .stream();
        boolean sn = snackStream.anyMatch(e-> e.getKey()<1 ||
                e.getKey() > 100 || e.getValue() < 1 || e.getValue() > 100);

        Stream<Map.Entry<Integer, Integer>> ladderStream = ladders
                .entrySet().stream();
        boolean ld = ladderStream.anyMatch(e -> e.getKey() >= e.getValue() ||
                        e.getKey() < 1 || e.getValue() > 100);

        boolean overlap = snakes.keySet().stream().anyMatch(ladders::containsKey);
        boolean snakeAfterLadder = ladders.values().stream().anyMatch(snakes::containsKey);

        return !(sn || ld || snakeAfterLadder|| overlap);
    }
    public int findMinRolls(){
        Queue<IntPair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        queue.offer(new IntPair(1,0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            IntPair current = queue.poll();
            int square = current.getFirst();
            int rolls = current.getSecond();

            if (square == 100) {
                return rolls;
            }
            for (int next : board.get(square)) {
                int dest = getJumpDestination(next).orElse(next);
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(new IntPair(dest, rolls + 1));
                }
            }
        }
        return -1;
    }
    public Optional<String> simulateGame(int totalPlayers){
        Map<String, Integer> players = new LinkedHashMap<>();
        for(int i=1; i<= totalPlayers; i++){
            players.put("Player"+i, 1);
        }
        Random random = new Random();
        BiConsumer<String, Integer> event = (player, pos) -> System.out.println(player + " moves to " + pos);
        while(true){
            for(String player : players.keySet()){
                int current = players.get(player);
                int dice = random.nextInt(6)+1;
                int next = current+dice;
                if(next > 100){
                    continue;
                }
                int dest = getJumpDestination(next).orElse(next);
                event.accept(player,dest);
                players.put(player,dest);

                if(dest == 100){
                    return Optional.of(player);
                }
            }
        }
    }
}
