import java.util.Arrays;
import java.util.List;

public class Driver {
    public static <T extends Number> void printTree(String name, NumberST<T> st) {
        System.out.println("\n" + name + ":");
        for (int i = 1; i < st.st.size(); i++) {
            System.out.println("Index " + i + " -> " + st.st.get(i));
        }
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(5, 8, 6, 3, 2, 7, 2, 6);

        NumberST<Integer> stSum = new NumberST<>(data, 0, Integer::sum);
        NumberST<Integer> stProduct = new NumberST<>(data, 1, (a, b) -> a * b);
        NumberST<Integer> stMax = new NumberST<>(data, Integer.MIN_VALUE, Math::max);
        NumberST<Integer> stMin = new NumberST<>(data, Integer.MAX_VALUE, Math::min);
        NumberST<Integer> stGCD = new NumberST<>(data, 0, Driver::gcd);

        System.out.println("Input Data: " + data);

//        printTree("SUM TREE", stSum);
//        printTree("PRODUCT TREE", stProduct);
//        printTree("MAX TREE", stMax);
//        printTree("MIN TREE", stMin);
        printTree("GCD TREE", stGCD);

//        stSum.update(2,8);
//        printTree("Sum Updated Tree", stSum);

//        stProduct.update(0,8);
//        printTree("Updated Product Tree:", stProduct);

    }

}
