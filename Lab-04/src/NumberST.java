import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class NumberST<T extends Number> {
    public List<T> data;
    public List<T> st;
    T identity;
    BinaryOperator<T> mergeFun;
    int paddedSize;

    public NumberST(List<T> data, T identity, BinaryOperator<T> mergeFun) {
        this.data = data;
        this.identity = identity;
        this.mergeFun = mergeFun;
        this.paddedSize = getNextPower2(data.size());
        this.st = new ArrayList<T>(Collections.nCopies(2 * paddedSize, identity));
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
            st.set(i, mergeFun.apply(st.get(2 * i), st.get(2 * i + 1)));
        }
    }

    public void update(int index, T value) {
        data.set(index, value);

        int parent = paddedSize + index;
        st.set(parent, value);
        parent = parent / 2;

        while (parent > 0) {
            st.set(parent,mergeFun.apply(st.get(2*parent),st.get(2*parent+1)));
            parent = parent / 2;
        }
    }
    public void update(int idx, UnaryOperator<T> fun){
        T val = fun.apply(data.get(idx));
        update(idx,val);
    }
    public T query(int l, int r){
        if(l < 0 || r >= data.size() || l > r){
            throw new IllegalArgumentException("Invalid range:");
        }
        return queryHelper(l,r,0,paddedSize-1,1);
    }
    private T queryHelper(int l, int r, int start, int end, int node){
        if(l <= start && end <= r){
            return st.get(node);
        }
        if(r < start || l > end){
            return identity;
        }
        else {
            int mid = (start + end)/2;
            T leftVal = queryHelper(l,r,start, mid, 2*node);
            T rightVal = queryHelper(l, r, mid + 1, end, 2 * node + 1);
            return mergeFun.apply(leftVal,rightVal);
        }
    }
}
