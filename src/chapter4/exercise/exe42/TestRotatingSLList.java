package chapter4.exercise.exe42;

import org.junit.Test;

public class TestRotatingSLList {

    @Test
    public void testRotateRight() {
        RotatingSLList<Integer> list = new RotatingSLList<>();
        list.addFirst(5);
        list.addLast(9);
        list.addLast(15);
        list.addLast(22);
        System.out.println(list);
        System.out.println(list.rotateRight());
    }
}
