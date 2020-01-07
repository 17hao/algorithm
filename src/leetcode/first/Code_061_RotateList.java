package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 旋转链表
 *
 * @since 2020-1-7 12:28
 */
public class Code_061_RotateList {
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        cur.next = head;
        int realK = count - k % count;
        ListNode node = head;
        for (int i = 0; i < realK - 1; i++) {
            node = node.next;
        }
        ListNode res = node.next;
        node.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode h2 = LinkedListTool.generateList(new int[]{1});
        LinkedListTool.printList(rotateRight(h1, 2));
        LinkedListTool.printList(rotateRight(h2, 2));
        // LinkedListTool.printList(rotateRight(h1, 3));
        // LinkedListTool.printList(rotateRight(h1, 4));
        // LinkedListTool.printList(rotateRight(h1, 5));
    }
}
