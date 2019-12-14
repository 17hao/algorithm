package leetcode.second;

import tool.ListNode;

/**
 * 环形链表
 *
 * @since 2019-12-14 Saturday
 */
public class Code_141_LinkedListCycle {
    boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        if (fastPointer.next == null) return false;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
