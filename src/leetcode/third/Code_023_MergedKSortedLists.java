package leetcode.third;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 合并k个有序链表
 *
 * @since 2020-4-4 Saturday 23:10 - 23:38
 */
public class Code_023_MergedKSortedLists {
    static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        return mergeHelper(lists, 0, len - 1);
    }

    private static ListNode mergeHelper(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + (r - l) / 2;
        ListNode l1 = mergeHelper(lists, l, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, r);
        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
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
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3});
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 4, 6});
        ListNode h3 = LinkedListTool.generateList(new int[]{2, 5, 8, 11});
        LinkedListTool.printList(mergeKLists(new ListNode[]{h1, h2, h3}));
    }
}
