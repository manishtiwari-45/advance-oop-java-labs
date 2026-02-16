import java.util.*;

public class Graph {
    private List<List<Integer>> graph = new ArrayList<>();
    private int totalNodes;
    private Deque<Integer> queue;
    private boolean[] visited;

    public Graph(int totalNodes) {
        if (totalNodes < 1) {
            throw new IllegalArgumentException("Number of vertices must be at least 1.");
        }
        this.totalNodes = totalNodes;
        for (int i = 0; i < totalNodes; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public int getTotalNodes() {
        return totalNodes;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= totalNodes) {
            throw new IllegalArgumentException(
                    "Invalid vertex: " + v + ". Valid range is 0 to " + (totalNodes - 1));
        }
    }

    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);

        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void bfs(int start) {

        validateVertex(start);
        visited = new boolean[totalNodes];
        queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        System.out.println("BFS Traversal starting from " + start + ":");
        while (!queue.isEmpty()) {

            int currNode = queue.poll();
            System.out.print(currNode + " ");
            for (int neighbor : graph.get(currNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}
