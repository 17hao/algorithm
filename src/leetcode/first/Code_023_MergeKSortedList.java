package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 合并k个有序链表
 *
 * @since 2020-1-23
 */
public class Code_023_MergeKSortedList {
    ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        return merge(lists, 0, len - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        Code_023_MergeKSortedList c = new Code_023_MergeKSortedList();
        ListNode l1 = LinkedListTool.generateList(new int[]{1, 4, 5});
        ListNode l2 = LinkedListTool.generateList(new int[]{1, 3, 4});
        ListNode l3 = LinkedListTool.generateList(new int[]{2, 6});
        LinkedListTool.printList(c.mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
