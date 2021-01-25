package chapter9.exercise;

public class QuickUnionDS implements DisjointSets{

    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for(int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    private int find(int i) {
        while (parent[i] >= 0) {
            i = parent[i];
        }
        return i;
    }

    @Override
    public void connect(int i, int j) {
        int p = find(i);
        int q = find(j);
        parent[p] = q;
    }

    @Override
    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }
}
