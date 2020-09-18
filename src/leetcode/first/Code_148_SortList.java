package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 在 O(n * log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * @since 2019-12-30 Monday 14:09
 */
public class Code_148_SortList {
    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(temp);
        ListNode h = new ListNode(Integer.MIN_VALUE);
        ListNode res = h;
        while (l != null && r != null) {
            if (l.val < r.val) {
                h.next = new ListNode(l.val);
                l = l.next;
            } else {
                h.next = new ListNode(r.val);
                r = r.next;
            }
            h = h.next;
        }
        h.next = l == null ? r : l;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{2, 1, 5, 2, 6, 2});
        LinkedListTool.printList(sortList(h1));
        ListNode h2 = LinkedListTool.generateList(new int[]{2, 9, 5, 1, 6, 2});
        LinkedListTool.printList(sortList(h2));
        ListNode h3 = LinkedListTool.generateList(new int[]{4, 1, 5, 3, 6, 2});
        LinkedListTool.printList(sortList(h3));
    }
}
