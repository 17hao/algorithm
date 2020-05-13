package leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个LRU缓存, put()和get()在O(1)时间复杂度内完成
 *
 * @update 2020-5-13 09:30
 * @since 2020-4-17 Friday 09:46
 */
public class Code_146_LRU_Cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        // cache.put(1, 1);
        // cache.put(2, 2);
        // System.out.println(cache.get(1));
        // cache.put(3, 3);
        // System.out.println(cache.get(2));
        // cache.put(4, 4);
        // System.out.println(cache.get(1));
        // System.out.println(cache.get(3));
        // System.out.println(cache.get(4));
        // ###
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
    }
}

class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private final DoublyLinkedList list;

    private static class Node {
        private final int key, val;
        private Node pre, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class DoublyLinkedList {
        private final Node head, tail;
        private int size = 0;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node n) {
            Node tmp = head.next;
            head.next = n;
            n.next = tmp;
            tmp.pre = n;
            n.pre = head;
            size++;
        }

        Node removeLast() {
            Node res = tail.pre;
            Node pre = res.pre;
            pre.next = tail;
            tail.pre = pre;
            size--;
            return res;
        }

        void remove(Node n) {
            Node next = n.next, pre = n.pre;
            pre.next = next;
            next.pre = pre;
            size--;
        }

        int size() {
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node n = map.get(key);
            put(key, n.val);
            return n.val;
        }
    }

    /**
     * 如果key存在:
     *      删除旧的节点
     *      插入新节点到头部
     *      更新map中的映射
     * 如果key不存在:
     *      如果缓存已满:
     *          将缓存尾节点删除
     *          删除map中的映射
     *  不论key是否存在:
     *          将元素插入到头结点
     *          在map中建立新的映射
     */
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            list.remove(map.get(key));
        } else {
            if (capacity == list.size()) {
                Node n = list.removeLast();
                map.remove(n.key);
            }
        }
        list.addFirst(newNode);
        map.put(key, newNode);
    }

}
