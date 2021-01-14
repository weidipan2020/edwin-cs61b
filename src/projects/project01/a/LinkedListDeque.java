package projects.project01.a;

import projects.project01.b.Deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class LLNode {
        public T val;
        public LLNode pre;
        public LLNode next;

        public LLNode(T val, LLNode pre, LLNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    private int size;
    private LLNode sentinel;

    public LinkedListDeque() {
        sentinel = new LLNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new LLNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size; i++) {
            addLast(other.get(i));
        }
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getR(sentinel.next, index);
    }

    private T getR(LLNode cur, int i) {
        if (i == 0) {
            return cur.val;
        }
        return getR(cur.next, i - 1);
    }
//
    public void addFirst(T item) {
        LLNode tmp = sentinel.next;
        sentinel.next = new LLNode(item, sentinel, tmp);
        tmp.pre = sentinel.next;
        size += 1;
    }
//
    public void addLast(T item) {
        LLNode tmp = sentinel.pre;
        sentinel.pre = new LLNode(item, tmp, sentinel);
        tmp.next = sentinel.pre;
        size += 1;
    }
//
    public boolean isEmpty() {
        return sentinel.next.equals(sentinel);
    }
//
    public int size() {
        return size;
    }
//
    public void printDeque() {
        LLNode cur = this.sentinel.next;
        while (!cur.equals(this.sentinel)) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println("\n");
    }
//
    public T removeFirst() {
        if (sentinel.next.equals(sentinel)) {
            return null;
        }
        LLNode tmp = sentinel.next;
        tmp.next.pre = sentinel;
        sentinel.next = tmp.next;
        size -= 1;
        return tmp.val;
    }
//
    public T removeLast() {
        if (sentinel.pre.equals(sentinel)) {
            return null;
        }
        LLNode tmp = sentinel.pre;
        tmp.pre.next = sentinel;
        sentinel.pre = tmp.pre;
        size -= 1;
        return tmp.val;
    }
//
    public T get(int index) {
        LLNode cur = this.sentinel.next;
        while (index > 0) {
            if (cur.equals(sentinel)) {
                return null;
            }
            cur = cur.next;
            index -= 1;
        }
        return cur.val;
    }

}
