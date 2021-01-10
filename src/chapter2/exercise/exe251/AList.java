package chapter2.exercise.exe251;

/**
 * Array based list.
 *
 * @author Josh Hug
 */

/**
 * Optional Exercise 2.5.1:
 * Try to build an AList class that supports addLast, getLast, get, and size operations.
 * Your AList should work for any size array up to 100. For starter code,
 * see https://github.com/Berkeley-CS61B/lectureCode/tree/master/lists4/DIY.
 */
public class AList<Glorp> {

    private int length;
    private Glorp[] array;
    private int maxLength = 100;

    /**
     * Creates an empty list.
     */
    public AList() {
        array = (Glorp[]) new Object[maxLength];
        length = 0;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Glorp x) {
        if (length == maxLength) {
            Glorp[] newArray = (Glorp[]) new Object[maxLength * 2];
            System.arraycopy(array, 0, newArray, 0, maxLength);
            maxLength *= 2;
            array = newArray;
        }
        array[length] = x;
        length++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public Glorp getLast() {
        if (length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[length - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Glorp get(int i) {
        if (i >= 0 && i < maxLength) {
            return array[i];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return length;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public Glorp removeLast() {
        length--;
        Glorp tmp = array[length];
        array[length] = null;
        return tmp;
    }

    public static void main(String[] args) {
        AList list = new AList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list.size());
        System.out.println(list.getLast());
        System.out.println(list.removeLast());
        System.out.println(list.get(2));
        System.out.println(list.size());
    }
}