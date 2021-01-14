package projects.project01.b;

public class OffByN implements CharacterComparator{

    int N;

    OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff1 = x - y;
        int diff2 = y - x;
        return diff1 == N || diff2 == N;
    }
}
