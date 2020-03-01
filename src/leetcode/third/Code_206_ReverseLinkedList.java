package leetcode.third;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 翻转链表(迭代和递归)
 *
 * @since 2020-3-1 22:15
 */
public class Code_206_ReverseLinkedList {
    static ListNode reverseListIterate(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6});
        LinkedListTool.printList(reverseListIterate(h1));
        LinkedListTool.printList(reverseListRecursive(h2));
    }
}
