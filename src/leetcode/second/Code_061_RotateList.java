package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @since 2020-6-3 Wednesday 19:02 - 19:20
 */
public class Code_061_RotateList {
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, tail;
        int len = 0;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        tail = cur;
        cur = dummy;
        int realK = k % len;
        if (realK == 0) return head;
        while ((len - realK) > 0) {
            cur = cur.next;
            len--;
        }
        ListNode res = cur.next;
        cur.next = null;
        tail.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 2, 3, 4});
        LinkedListTool.printList(rotateRight(head, 1)); // 4 -> 1 -> 2 -> 3
        // LinkedListTool.printList(rotateRight(head, 2)); // 3 -> 4 -> 1 -> 2
        // LinkedListTool.printList(rotateRight(head, 4));
        // LinkedListTool.printList(rotateRight(head, 5));
    }
}
