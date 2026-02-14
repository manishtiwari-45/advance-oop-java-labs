import java.util.*;

public class TravelGraph {
    private final Map<City, List<City>> graph;

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
        if(from == null && to == null){
            return;
        }
        graph.get(from).add(to);
    }
    public String findPath(City start, City destination){
        ArrayDeque<City> stack = new ArrayDeque<>();
        Set<City> visited = new HashSet<>();
        System.out.println("Hello");
    }
}
