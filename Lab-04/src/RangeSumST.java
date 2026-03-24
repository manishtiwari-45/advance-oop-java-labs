import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumST {
    public List<Integer> data;
    public List<Integer> st;
    int paddedSize;

    public RangeSumST(List<Integer> data) {
        this.data = data;
        this.paddedSize = getNextPower2(data.size());
        this.st = new ArrayList<>(Collections.nCopies(2 * paddedSize, 0));
        build();
    }

    public int getNextPower2(int n) {
        int k = 1;
        while (k < n) {
            k *= 2;
        }
        return k;
    }

    public void build() {
        for (int i = 0; i < data.size(); i++) {
            st.set(paddedSize + i, data.get(i));
        }
        for (int i = paddedSize - 1; i > 0; i--) {
            st.set(i, st.get(2 * i) + st.get(2 * i + 1));
        }
    }
//    public void build(int node) {
//        if (node >= paddedSize) {
//            int dataIndex = node - paddedSize;
//            st.set(node, data.get(dataIndex));
//        } else {
//            build(2 * node);
//            build(2 * node + 1);
//            st.set(node, st.get(2 * node) + st.get(2 * node + 1));
//        }
//    }
    public void update(int index, int value) {
        data.set(index, value);

        int node = paddedSize + index;
        st.set(node, value);
        node = node / 2;

        while (node > 0) {
            st.set(node, st.get(2 * node) + st.get(2 * node + 1));
            node = node / 2;
        }
    }
    public int query(int l, int r){
        if(l < 0 || r >= data.size() || l > r){
            throw new IllegalArgumentException("Invalid range:");
        }
        return queryHelper(l,r,0,paddedSize-1,1);
    }
    private int queryHelper(int l, int r, int start, int end, int node){
        if(l <= start && end <= r){
            return st.get(node);
        }
        if(r < start || l > end){
            return 0;
        }
        else {
            int mid = (start + end)/2;
            int leftVal  = queryHelper(l, r, start, mid,   2*node);
            int rightVal = queryHelper(l, r, mid+1, end,   2*node+1);
            return leftVal + rightVal;
        }
    }
}
