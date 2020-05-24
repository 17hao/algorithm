//package algorithms4th.chapter_1_Fundamentals.section3;
//
//import edu.princeton.cs.algs4.StdOut;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class Stack<Item> implements Iterable<Item> {
//    // 用链表实现的栈
//    // page94
//    // 出栈入栈都是对链表尾节点操作
//    private Node<Item> first; // 栈顶元素
//    private int N; // 栈的大小
//
//    private class Node<Item> {
//        Item item;
//        Node<Item> next;
//    }
//
//    // 初始化一个栈
//    public Stack() {
//        first = null;
//        N = 0;
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return new ListIterator<Item>(first);
//    }
//
//    // 一个迭代器
//    private class ListIterator<Item> implements Iterator<Item> {
//        private Node<Item> current;
//
//        public ListIterator(Node<Item> first) {
//            current = first;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        @Override
//        public Item next() {
//            if (!hasNext()) {
//                throw new UnsupportedOperationException();
//            }
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//    }
//
//    private boolean isEmpty() {
//        return first == null;
//    }
//
//    public int size() {
//        return N;
//    }
//
//    private void push(Item item) {
//        // 向栈顶添加元素
//        Node oldfirst = first;
//        first = new Node<Item>();
//        first.item = item;
//        first.next = oldfirst;
//        N++;
//    }
//
//    private Item pop() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("Stack underflow");
//        }
//        // 从栈顶弹出一个元素
//        Item item = first.item;
//        first = first.next;
//        N--;
//        return item;
//    }
//
//    private Item peek() {
//        // 返回栈顶的元素但不删除
//        if (isEmpty()) {
//            throw new NoSuchElementException("Stack underflow");
//        }
//        return first.item;
//    }
//
//    public static void main(String[] args) {
//        Stack<String> s = new Stack<>();
//        String[] strings = {"to", "be", "or", "not", "-", "to", "-", "be"};
//        for (String string : strings) {
//            if (!string.equals("-")) {
//                s.push(string);
//            } else if (!s.isEmpty()) {
//                StdOut.print(s.pop() + " ");
//            }
//        }
//        StdOut.print("(" + s.size() + " left on stack)");
//    }
//}
