package labs.lab6;

public class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    public void validate(int v1) {
        if (v1 >= parent.length) {
            throw new IllegalArgumentException();
        }
    }

    public int sizeOf(int v1) {
        return - find(v1);
    }

    public int parent(int v1) {
        return parent[v1];
    }

    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        if (parent[root1] < parent[root2]) {
            parent[root1] = parent[root1] + parent[root2];
            parent[root2] = v1;
        } else {
            parent[root2] = parent[root1] + parent[root2];
            parent[root1] = v2;
        }
    }

    public int find(int v1) {
        while (parent[v1] >= 0) {
            v1 = parent[v1];
        }
        return v1;
    }
}
