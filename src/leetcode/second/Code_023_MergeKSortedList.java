package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 合并k个有序链表
 *
 * @since 2020-2-8
 */
public class Code_023_MergeKSortedList {
    static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        return mergeHelper(lists, 0, len - 1);
    }

    private static ListNode mergeHelper(ListNode[] lists, int x, int y) {
        if (x == y) return lists[x];
        int mid = x + ((y - x) >>> 1);
        ListNode l1 = mergeHelper(lists, x, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, y);
        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.generateList(new int[]{1, 3, 4});
        ListNode l2 = LinkedListTool.generateList(new int[]{1, 5, 6});
        ListNode l3 = LinkedListTool.generateList(new int[]{2, 9});
        ListNode result = mergeKLists(new ListNode[]{l1, l2, l3});
        LinkedListTool.printList(result);
    }
}
