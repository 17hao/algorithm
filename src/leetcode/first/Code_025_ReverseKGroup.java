package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * k个一组翻转链表
 *
 * @since 2020-5-30 Saturday 22:37 - 23:26
 */
public class Code_025_ReverseKGroup {
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy, start, end = dummy, next;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            next = end.next;
            end.next = null;
            start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head3 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head4 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head5 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        LinkedListTool.printList(reverseKGroup(head1, 1));
        LinkedListTool.printList(reverseKGroup(head2, 2));
        LinkedListTool.printList(reverseKGroup(head3, 3));
        LinkedListTool.printList(reverseKGroup(head4, 5));
        LinkedListTool.printList(reverseKGroup(head5, 6));
    }
}
