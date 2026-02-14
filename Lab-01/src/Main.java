import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter 4 edges (u v):");

            for (int i = 0; i < 4; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                g.addEdge(u, v);
            }

            System.out.println("Enter starting node for BFS:");
            int start = sc.nextInt();

            g.bfs(start);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
