package chapter6.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * returns an iterator (a.k.a. seer) into ME
     */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(items[i]);
            sb.append(", ");
        }
        sb.append(items[size - 1]);
        sb.append("}");
        return sb.toString();
        
    }


    @Override
    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (this == other) { return true; }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> otherSet = (ArraySet<T>) other;
        if (otherSet.size() != this.size()) return false;
        for (T t : this) {
            if (!otherSet.contains(t)) {
                return false;
            };
        }
        return true;
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... args) {
        ArraySet<Glerp> set = new ArraySet<>();
        for (Glerp arg : args) {
            set.add(arg);
        }
        return set;
    }


    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);

        //equals
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));

        System.out.println(ArraySet.of("I", "Like", "Fish"));

    }
}