package leetcode.first;

import tool.ListNode;

/**
 * 环形链表2
 * 返回链表成环的入口
 *
 * @since 2020-4-9 Thursday 23:11
 */
public class Code_142_LinkedListCycle2 {
    static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
