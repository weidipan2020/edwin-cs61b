package chapter9.exercise;

public interface DisjointSets {

    void connect(int i, int j);

    boolean isConnected(int i, int j);
}
