import java.util.List;

public class TravelPlannerTest {

    /*
     Conceptual Questions:

     1. Stack vs Queue:
        DFS uses a Stack because it explores nodes deep as deep possible first.
        BFS uses a Queue because it explores node level-by-level.

     2. Immutability Benefits:
        - Objects cannot change unexpectedly
        - Thread-safe
        - Perfect for Map keys (hashCode never changes)

     3. Shortest Path:
        DFS does NOT guarantee shortest path.
        BFS guarantees shortest path in unweighted graphs.

     4. Real Flight System:
        Add cost, duration, airline, layover time.

     5. Encapsulation Examples:
        - adjacencyList is private
        - Cities added only via addCity()
        - DFS logic hidden inside findPath()
     */

    public static void main(String[] args) {

        City delhi = new City("Delhi", "India", "IST");
        City indore = new City("Indore", "India", "IST");
        City pune = new City("Pune", "India", "IST");
        City newYork = new City("New York", "USA", "EST");
        City london = new City("London", "UK", "GMT");
        City paris = new City("Paris", "France", "CET");
        City tokyo = new City("Tokyo", "Japan", "JST");
        City dubai = new City("Dubai", "UAE", "GST");
        City mumbai = new City("Mumbai", "India", "IST");

        TravelGraph graph = new TravelGraph();

        graph.addCity(newYork);
        graph.addCity(london);
        graph.addCity(paris);
        graph.addCity(tokyo);
        graph.addCity(delhi);
        graph.addCity(dubai);
        graph.addCity(pune);
        graph.addCity(mumbai);
        graph.addCity(indore);

        graph.addConnection(newYork, london);
        graph.addConnection(london, paris);
        graph.addConnection(paris, tokyo);
        graph.addConnection(tokyo, delhi);
        graph.addConnection(delhi, indore);
        graph.addConnection(indore, pune);
        graph.addConnection(pune, mumbai);


        List<City> route = graph.findPath(newYork, mumbai);
        if (route.isEmpty()) {
            System.out.println("No route exists.");
        } else {
            System.out.print("Travel Route: ");
            for (int i = 0; i < route.size(); i++) {
                System.out.print(route.get(i).getName());
                if (i < route.size() - 1)
                    System.out.print(" → ");
            }
            System.out.println();
        }

        System.out.println("\nFinding route from Paris to Mumbai:");
        List<City> route2 = graph.findPath(paris, mumbai);

        if (route2.isEmpty()) {
            System.out.println("No route exists.");
        } else {
            System.out.println(route2);
        }

        try {
            graph.findPath(null, dubai);
        } catch (IllegalArgumentException e) {
            System.out.println("\nException Test Passed: " + e.getMessage());
        }
    }
}
