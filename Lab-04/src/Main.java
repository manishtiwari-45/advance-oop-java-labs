import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(5,8,6,3,2,7,2,6);
        RangeSumST tree = new RangeSumST(data);

        System.out.println("Padded Size: " + tree.paddedSize);
        System.out.println("Segment Tree Array:");

        tree.update(2,8);
        for (int i = 1; i < tree.st.size(); i++) {
            System.out.println("Index: " + i + " " + tree.st.get(i));
        }
    }
}