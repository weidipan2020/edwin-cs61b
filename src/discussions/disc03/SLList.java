
package discussions.disc03;
public class SLList<E> {

    private Node<E> first;
    private int size;

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(E x) {
        first = new Node(x, null);
        size = 1;
    }

    public void addFirst(E x) {
        first = new Node(x, first);
        size += 1;
    }

    public void addLast(E x) {
        Node<E> cur = first;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(x, null);
        size += 1;
    }

    public E getFirst() {
        return first.item;
    }

    public E getLast() {
        Node<E> cur = first;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur.item;
    }

    public E get(int i) {
        Node<E> cur = first;
        while (i > 0 && cur.next != null) {
            i -= 1;
            cur = cur.next;
        }
        return cur.item;
    }

    public int size() {
        return size;
    }

    public E removeLast() {
        Node<E> cur = first;
        Node<E> pre = null;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        size -= 1;
        return cur.item;
    }

    /*
    1.1 Implement SLList.insert which takes in an integer x and an integer position. It
inserts x at the given position. If position is after the end of the list, insert the
new node at the end.
    */

    public void insert(E item, int position) {
        Node cur = first;
        while (position > 1 && cur.next != null) {
            position -= 1;
            cur = cur.next;
        }
        cur.next = new Node(item, cur.next);
        size += 1;
    }
    /*
    1.2 Add another method to the SLList class that reverses the elements. Do this using
the existing IntNode objects (you should not use new).
    */

    public void reverse() {
        Node newFirst = null;
        Node cur = first;
        Node nxt = first.next;
        while (cur != null) {
            cur.next = newFirst;
            newFirst = cur;
            cur = nxt;
            nxt = nxt == null ? null : nxt.next;
        }
        first = newFirst;
    }
    /*
    1.3 Extra: If you wrote reverse iteratively, write a second version that uses recursion
    (you may need a helper method). If you wrote it recursively, write it iteratively.
    */

    public void recursionReverse() {
        helper(first);
    }
    private void helper(Node cur) {
        if (cur.next == null) {
            first = cur;
            return;
        }
        helper(cur.next);
        Node end = cur.next;
        end.next = cur;
        cur.next = null;
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = first;
        while (cur != null) {
            sb.append(cur.item).append(", ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SLList<Integer> list = new SLList();
        list.addFirst(1);
        list.insert(2,1);
        list.insert(3,2);
        list.insert(4,1);
        list.insert(5,10);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.recursionReverse();
        System.out.println(list);
    }

}

class Node<E> {
    public E item;
    public Node next;
    public Node(E item, Node next) {
        this.item = item;
        this.next = next;
    }
}
