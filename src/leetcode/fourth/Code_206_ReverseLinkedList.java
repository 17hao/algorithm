package leetcode.fourth;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 反转链表
 *
 * @since 2020-4-5 Sunday 21:40 - 21:48
 */
public class Code_206_ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode dummyNext = dummy.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        LinkedListTool.printList(reverseList(head));
    }
}
