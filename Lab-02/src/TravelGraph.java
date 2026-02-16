import java.util.*;

public class TravelGraph {
    private final Map<City, List<City>> graph ;

    public TravelGraph() {
        graph = new HashMap<>();
    }

    public void addCity(City city){
        if(graph.containsKey(city)){
            return;
        }
        graph.put(city, new ArrayList<>());
    }
    public void addConnection(City from, City to){
        if(!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("Both cities must exist in graph");
        }
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
    public List<City> findPath(City start, City destination){
        if(start == null || destination == null ||
                !graph.containsKey(start) ||
                !graph.containsKey(destination)){
            throw new IllegalArgumentException("Start or destination city is invalid");
        }

        ArrayDeque<City> stack = new ArrayDeque<>();
        Set<City> visited = new HashSet<>();
        Map<City, City> parent = new HashMap<>();

        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()){
            City curr = stack.pop();
            if(curr.equals(destination)){
                break;
            }
            for(City neighbour : graph.get(curr)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    parent.put(neighbour, curr);
                    stack.push(neighbour);
                }
            }
        }
        if (!start.equals(destination) && !parent.containsKey(destination)) {
            return new ArrayList<>();
        }

        List<City> path = new ArrayList<>();
        City node = destination;
        while (node != null){
            path.add(node);
            node = parent.get(node);
        }
        Collections.reverse(path);
        return path;
    }
}
