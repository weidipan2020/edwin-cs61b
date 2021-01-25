package chapter8.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExtensionStack<Item> extends LinkedList<Item> {
    public void push(Item x) {
        add(x);
    }
}

class DelegationStack<Item> {
    private List<Item> list = new ArrayList<>();
    public void push(Item x) {
        list.add(x);
    }
}

class StackAdapter<Item> {
    private List<Item> list;

    public StackAdapter(List<Item> list) {
        this.list = list;
    }

    public void push(Item x) {
        list.add(x);
    }
}
