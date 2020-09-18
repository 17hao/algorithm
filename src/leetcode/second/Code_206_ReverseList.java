package leetcode.second;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 反转单链表
 *
 * @since 2019-12-14 Saturday
 */
public class Code_206_ReverseList {
    static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tempHead = dummy.next;
            ListNode newHead = cur.next;
            ListNode next = cur.next.next;
            dummy.next = newHead;
            newHead.next = tempHead;
            cur.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        LinkedListTool.printList(head);
        System.out.println("\n===");
        LinkedListTool.printList(reverseList(head));
    }
}
