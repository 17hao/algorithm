package leetcode.second;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * @since 2020-3-7
 */
public class Code_148_SortList {
    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{4, 2, 1, 3});
        LinkedListTool.printList(sortList(h1));
        ListNode h2 = LinkedListTool.generateList(new int[]{6, 2, 2, 1, 3});
        LinkedListTool.printList(sortList(h2));
    }
}
