package labs.lab2;

import java.util.Formatter;

public class IntList {
    int first;
    IntList rest;

    IntList(int first) {
        this.first = first;
        this.rest = null;
    }

    IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }


    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    public static IntList squareListIterative(IntList L) {
        IntList newHead = new IntList(L.first * L.first);
        IntList cur = newHead;
        L = L.rest;
        while (L != null) {
            cur.rest = new IntList(L.first * L.first);
            cur = cur.rest;
            L = L.rest;
        }
        return newHead;
    }

    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        IntList restList = squareListRecursive(L.rest);
        IntList curList = new IntList(L.first * L.first, restList);
        return curList;
    }

    public static IntList dcatenate(IntList A, IntList B) {
        if (A == null) {
            return B;
        }
        IntList cur = A;
        while (cur.rest != null) {
            cur = cur.rest;
        }
        cur.rest = B;
        return A;
    }

    static IntList catenate(IntList A, IntList B) {
        if (A == null) {
            return B;
        }
        IntList newHead = new IntList(A.first);
        IntList cur = newHead;
        A = A.rest;
        while (A != null) {
            cur.rest = new IntList(A.first);
            cur = cur.rest;
            A = A.rest;
        }
        while (B != null) {
            cur.rest = new IntList(B.first);
            cur = cur.rest;
            B = B.rest;
        }
        return newHead;
    }

    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return first;
    }

    /**
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static IntList of(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof IntList)) {
            return false;
        }
        IntList L = (IntList) x;
        IntList p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an IntList into a String and that IntList has a loop, your computer
     * doesn't get stuck in an infinite loop.
     */

    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null) {
            return 0;
        }

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null) {
                hare = hare.rest.rest;
            } else {
                return 0;
            }

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntList p = this; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }

}
