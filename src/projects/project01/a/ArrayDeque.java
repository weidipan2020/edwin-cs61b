package projects.project01.a;

import projects.project01.b.Deque;

import java.util.Arrays;

public class ArrayDeque<E> implements Deque<E> {

    private E[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (E[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque<E> other) {
        this();
        for (int i = 0; i < other.size; i++) {
            addLast(other.get(i));
        }
        
    }

    public void increaseSize() {
        int len = array.length;
        E[] newArray = (E[]) new Object[len * 2];
        int newFirst = 0;
        int newLast = 1;
        int cur = (nextFirst + 1) % len;
        while (cur != nextLast) {
            newArray[newLast] = array[cur];
            cur = (cur + 1) % len;
            newLast += 1;
        }
        array = newArray;
        nextFirst = newFirst;
        nextLast = newLast;
    }

    private void decreaseSize(int len) {

        E[] newArray = (E[]) new Object[len];
        int newFirst = 0;
        int newLast = 1;
        int cur = (nextFirst + 1) % array.length;
        while (cur != nextLast) {
            newArray[newLast] = array[cur];
            cur = (cur + 1) % array.length;
            newLast += 1;
        }
        array = newArray;
        nextFirst = newFirst;
        nextLast = newLast;
    }

    public void addFirst(E item) {
        if (nextFirst == nextLast) {
            increaseSize();
        }
        array[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst == 0) ? array.length - 1 : nextFirst - 1;
    }

    public void addLast(E item) {
        if (nextFirst == nextLast) {
            increaseSize();
        }
        array[nextLast] = item;
        size += 1;
        nextLast = (nextLast + 1) % array.length;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int cur = (nextFirst + 1) % array.length;
        StringBuffer sf = new StringBuffer();
        while (cur != nextLast) {
            sf.append(array[cur]);
            sf.append(" ");
            cur = (cur + 1) % array.length;
        }
        System.out.println(sf.toString());
    }

    public E removeFirst() {
        int newFirst = (nextFirst + 1) % array.length;
        if (newFirst == nextLast) {
            return null;
        }
        E tmp = array[newFirst];
        array[newFirst] = null;
        nextFirst = newFirst;
        checkUsage();
        size -= 1;
        return tmp;
    }

    public void checkUsage() {
        int len = array.length;
        boolean flag = false;
        while (len > 8 && (size * 4 < len)) {
            len = len / 2;
            flag = true;
        }
        if (flag) {
            decreaseSize(len);
        }
    }

    public E removeLast() {
        int newLast = (nextLast == 0) ? array.length - 1 : nextLast - 1;
        if (newLast == nextFirst) {
            return null;
        }
        E tmp = array[newLast];
        array[newLast] = null;
        nextLast = newLast;
        checkUsage();
        size -= 1;
        return tmp;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return array[(index + nextFirst + 1) % array.length];
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", nextFrist=" + nextFirst +
                ", nextLast=" + nextLast +
                '}';
    }

//    public ArrayDeque of(E... args) {
//        ArrayDeque<Object> deque = new ArrayDeque<>();
//        deque.
//        for (int i = 0;)
//    }
}
