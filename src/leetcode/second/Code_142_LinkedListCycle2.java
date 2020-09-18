package leetcode.second;

import leetcode.tool.ListNode;

/**
 * 环形链表2
 * 返回链表成环的入口
 *
 * @since 2020-4-11 Saturday 10:44 - 10:55
 */
public class Code_142_LinkedListCycle2 {
    ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        ListNode tmp = head;
        while (tmp != slow) {
            tmp = tmp.next;
            slow = slow.next;
        }
        return tmp;
    }
}
