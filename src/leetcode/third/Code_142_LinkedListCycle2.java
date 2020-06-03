package leetcode.third;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 环形链表2
 *
 * @since 2020-6-3 Wednesday 19:30 - 19:50
 */
public class Code_142_LinkedListCycle2 {
    static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null) {
            return null;
        } else {
            ListNode res = head;
            while (res != fast) {
                res = res.next;
                fast = fast.next;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 2});
        LinkedListTool.printList(detectCycle(head));
    }
}
