package algorithms4th.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    // 用链表实现的栈
    private class Node {
        Item item;
        Node next;
    }

    private Node first; // 栈顶元素
    private int N; // 栈的大小

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    private void push(Item item) {
        // 向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    private Item pop() {
        // 从栈顶弹出一个元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String[] strings = {"to", "be", "or", "not", "-", "to", "-", "be"};
        for (String string : strings) {
            if (!string.equals("-")) {
                s.push(string);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.print("(" + s.size() + " left on stack)");
    }
}
