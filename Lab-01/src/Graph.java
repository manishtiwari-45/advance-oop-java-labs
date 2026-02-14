import java.util.*;

public class Graph {
    private List<List<Integer>> adjList = new ArrayList<>();
    private int totalEdges;
    private int totalNodes;

    public Graph(int totalNodes) {
        this.totalNodes = totalNodes;
        for (int i = 0; i < totalNodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {

        if (a < 0 || a >= totalNodes || b < 0 || b >= totalNodes) {
            throw new IllegalArgumentException("Enter valid edges");
        }
        adjList.get(a).add(b);
        adjList.get(b).add(a);

        totalEdges++;
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[totalNodes];

        Queue<Integer> que = new LinkedList<>();

        visited[start] = true;
        que.offer(start);

        System.out.println("BFS Traversal:");
        while (!que.isEmpty()) {

            int node = que.poll();
            System.out.print(node + " -> ");

            for (int neighbor : adjList.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    que.offer(neighbor);
                }
            }
        }
    }
}
