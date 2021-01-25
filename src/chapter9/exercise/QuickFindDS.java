package chapter9.exercise;

public class QuickFindDS implements DisjointSets{
    private int[] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void connect(int i, int j) {
        int iid = id[i];
        int jid = id[j];
        for (int k = 0; k < id.length; k++) {
            if (id[i] == iid) {
                id[i] = jid;
            }
        }
    }

    @Override
    public boolean isConnected(int i, int j) {
        return id[i] == id[j];
    }
}
