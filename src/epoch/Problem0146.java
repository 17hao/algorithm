package epoch;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache
 *
 * @since 2021-5-8 Saturday 10:55
 * @update 2021-5-11 Tuesday 14:43
 */
public class Problem0146 {
    public static void main(String... args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}

class LRUCache {

    static class Node {
        Node pre, next;
        final int key;
        final int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    static class DoublyLinkedList {
        final Node head, tail;

        DoublyLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.next = next;
            node.pre = head;
            next.pre = node;
        }

        void remove(Node node) {
            Node next = node.next;
            Node pre = node.pre;
            pre.next = next;
            next.pre = pre;
        }

        Node removeLast() {
            Node last = tail.pre;
            Node newLast = tail.pre.pre;
            newLast.next = tail;
            tail.pre = newLast;
            return last;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> map;

    private final DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));
            map.remove(key);
        } else {
            if (map.size() == capacity) {
                Node last = list.removeLast();
                map.remove(last.key);
            }
        }
        Node node = new Node(key, value);
        list.addFirst(node);
        map.put(key, node);
    }
}
