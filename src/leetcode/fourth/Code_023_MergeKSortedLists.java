package leetcode.fourth;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 合并k个有序链表
 *
 * @since 2020-5-6 Wednesday 16:57 - 17:22
 */
public class Code_023_MergeKSortedLists {
    ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        return helper(lists, 0, len - 1);
    }

    ListNode helper(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + (r - l) / 2;
        ListNode l1 = helper(lists, l, mid);
        ListNode l2 = helper(lists, mid + 1, r);
        return merge2Lists(l1, l2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummy.next;
    }

    public static void main(String... args) {
        Code_023_MergeKSortedLists c = new Code_023_MergeKSortedLists();
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4});
        ListNode h2 = LinkedListTool.generateList(new int[]{2, 5, 9});
        ListNode h3 = LinkedListTool.generateList(new int[]{1, 6, 8, 10});
        LinkedListTool.printList(c.mergeKLists(new ListNode[]{h1, h2, h3}));
        // LinkedListTool.printList(c.merge2Lists(h2, h3));
    }
}
