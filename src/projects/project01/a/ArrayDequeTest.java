package projects.project01.a;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testincreaseSize() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque();
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);
        arrayDeque.addLast(9);
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(-1);

        System.out.println(arrayDeque);

        arrayDeque.increaseSize();
        System.out.println(arrayDeque);

    }

}