package algorithms4th.chapter_1_Fundamentals.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    // 用链表实现的队列
    // page96
    // 维护一个头和尾，分别用于出队列和入队列
    private Node<Item> first; // first还只是一个指针指向队列头，还不是一个完整的节点
    private Node<Item> last; // 队列尾
    private int N; // 队列大小

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    // 初始化一个队列
    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null; // 或者N == 0
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // 入队列
        Node<Item> oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        // 出队列
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public Item peek() {
        // 返回一个队列头元素但不删除
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    public class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            // current还只是一个指针还不是一个完整的节点
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue underflow");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        String[] strings = {"to", "be", "or", "not", "-", "to", "-", "be"};
        for (String string : strings) {
            if (!string.equals("-")) {
                queue.enqueue(string);
            }
        }

        for (String string : queue) {
            StdOut.print(string + " ");
        }
        StdOut.print("(" + queue.size() + " left on the queue)\n");

        //Iterator iterator = queue.iterator();
        //while (iterator.hasNext()) {
        //    StdOut.print(iterator.next() + " ");
        //}
        //StdOut.print("(" + queue.size() + " left on the queue)");
    }
}
