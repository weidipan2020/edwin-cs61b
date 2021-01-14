package chapter4.exercise.exe42;

import discussions.disc03.SLList;

public class RotatingSLList<Item> extends SLList<Item> {
    public SLList<Item> rotateRight() {
        Item tmp = removeLast();
        addFirst(tmp);
        return this;
    }
}

