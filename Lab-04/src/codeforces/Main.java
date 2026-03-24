//import java.util.*;
//import java.io.*;
//
//public class Main {
//
//    static class Node {
//        long min;
//        int count;
//
//        Node(long min, int count){
//            this.min = min;
//            this.count = count;
//        }
//    }
//
//
//    public List<Integer> data;
//    public List<Node> st;
//    int paddedSize;
//
//    public Main(List<Integer> data) {
//        this.data = data;
//        this.paddedSize = getNextPower2(data.size());
//        this.st = new ArrayList<>();
//        for (int i = 0; i < 2 * paddedSize; i++) {
//            st.add(new Node(Long.MAX_VALUE, 0));
//        }
//        build();
//    }
//
//    public int getNextPower2(int n) {
//        int k = 1;
//        while (k < n) {
//            k *= 2;
//        }
//        return k;
//    }
//
//    public void build() {
//        for (int i = 0; i < data.size(); i++) {
//            st.set(paddedSize + i, new Node(data.get(i),1));
//        }
//        for (int i = paddedSize - 1; i > 0; i--) {
//            st.set(i, merge(st.get(2 * i),st.get(2 * i + 1)));
//        }
//    }
//
//    private Node merge(Node a, Node b){
//        if (a.min < b.min) return new Node(a.min, a.count);
//        if (b.min < a.min) return new Node(b.min, b.count);
//
//        return new Node(a.min, a.count + b.count);
//    }
//
//    public void update(int index, int value) {
//        data.set(index, value);
//        int node = paddedSize + index;
//        st.set(node, new Node(value,1));
//        node = node / 2;
//        while (node > 0) {
//            st.set(node, merge(st.get(2 * node),st.get(2 * node + 1)));
//            node = node / 2;
//        }
//    }
//
//    public Node query(int l, int r) {
//        return queryHelper(l, r, 0, paddedSize - 1, 1);
//    }
//
//    private Node queryHelper(int l, int r, int start, int end, int node) {
//        if (l <= start && end <= r) {
//            return st.get(node);
//        }
//        if (r < start || l > end) {
//            return new Node(Long.MAX_VALUE,0);
//        } else {
//            int mid = (start + end) / 2;
//            Node leftVal  = queryHelper(l, r, start, mid,   2 * node);
//            Node rightVal = queryHelper(l, r, mid+1, end,   2 * node + 1);
//            return merge(leftVal,rightVal);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st1.nextToken());
//        int m = Integer.parseInt(st1.nextToken());
//
//        List<Integer> data = new ArrayList<>();
//        st1 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            data.add(Integer.parseInt(st1.nextToken()));
//        }
//
//        Main tree = new Main(data);
//
//        for (int i = 0; i < m; i++) {
//            st1 = new StringTokenizer(br.readLine());
//            int type = Integer.parseInt(st1.nextToken());
//            if (type == 1) {
//                int idx = Integer.parseInt(st1.nextToken());
//                int val = Integer.parseInt(st1.nextToken());
//                tree.update(idx, val);
//            } else {
//                int l = Integer.parseInt(st1.nextToken());
//                int r = Integer.parseInt(st1.nextToken());
//                Node res = tree.query(l,r-1);
//                sb.append(res.min).append(" ").append(res.count).append("\n");
//            }
//        }
//        System.out.print(sb);
//    }
//}