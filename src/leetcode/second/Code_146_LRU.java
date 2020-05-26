package leetcode.second;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 * @since 2020-5-23 Saturday 22:34
 */
public class Code_146_LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final LinkedList l;

    private static class Node {
        private int key;
        private int val;
        Node pre = null;
        Node next = null;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class LinkedList {

        private final Node head;
        private final Node tail;
        private int size;

        LinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        void remove(Node node) {
            Node p = node.pre;
            Node n = node.next;
            p.next = n;
            n.pre = p;
            size--;
        }

        Node removeTail() {
            Node res = tail.pre;
            Node t = tail.pre.pre;
            t.next = tail;
            tail.pre = t;
            size--;
            return res;
        }

        void insertHead(Node n) {
            Node h = head.next;
            head.next = n;
            n.next = h;
            h.pre = n;
            n.pre = head;
            size++;
        }

        int size() {
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.l = new LinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            l.remove(n);
            l.insertHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    /**
     * 如果缓存中不存在这个key
     *  1.缓存满了
     *      删除最后一个节点
     *      插入节点到头部
     *      删除尾节点的映射
     *      添加新节点的映射
     *  2.缓存未满
     *      插入节点到头部
     *      添加映射
     * 如果缓存中存在这个key
     *  删除旧节点
     *  插入节点到头部
     *  更新映射
     */
    public void put(int key, int value) {
        int size = l.size();
        Node n = new Node(key, value);
        if (!map.containsKey(key)) {
            if (size == capacity) {
                Node old = l.removeTail();
                map.remove(old.key);
            }
        } else {
            Node old = map.get(key);
            l.remove(old);
        }
        l.insertHead(n);
        map.put(key, n);
    }
}
