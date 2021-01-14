package projects.project01.a;

import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        Assert.assertTrue(ad1.isEmpty());

        ad1.addFirst("front");

        Assert.assertEquals(1, ad1.size());
        Assert.assertFalse(ad1.isEmpty());

        ad1.addLast("middle");
        Assert.assertEquals(2, ad1.size());

        ad1.addLast("back");
        Assert.assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        Assert.assertTrue(ad2.isEmpty());

        ad2.addFirst(10);
        Assert.assertFalse(ad2.isEmpty());

        ad2.removeFirst();
        Assert.assertTrue(ad2.isEmpty());
    }



}
