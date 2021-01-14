package chapter4.exercise.exe42;

import discussions.disc03.SLList;

public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList() {
        deletedItems = new SLList<Item>();
    }


    public void printLostItems() {
        System.out.println(deletedItems);
    }

    @Override
    public Item removeLast() {
        Item item = super.removeLast();
        deletedItems.addLast(item);
        return item;
    }

}
