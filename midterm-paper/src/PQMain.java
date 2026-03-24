import java.util.PriorityQueue;

public class PQMain {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.add(new Patient("Alice", 3, 1001));
        queue.add(new Patient("Bob", 1, 1002));
        queue.add(new Patient("Charlie", 2, 1000));
        queue.add(new Patient("Diana", 1, 1000));
        queue.add(new Patient("Ethan", 4, 1003));

        System.out.println("Treatment Order:");

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p);
        }
    }
}
