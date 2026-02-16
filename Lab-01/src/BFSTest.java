public class BFSTest {

    public static void main(String[] args) {

        System.out.println("Test Case 1: Normal Connected Graph");

        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);

        g1.bfs(0);
        g1.bfs(2);
        g1.getTotalNodes();

        System.out.println("\nTest Case 2: Linear Graph");

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        g2.bfs(2);


        System.out.println("\nTest Case 3: Disconnected Graph");

        Graph g3 = new Graph(6);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(3, 4);
        g3.addEdge(3, 5);

//        g3.bfs(-3);
        g3.bfs(0);
        g3.bfs(3);
        g3.getTotalNodes();

    }
}
