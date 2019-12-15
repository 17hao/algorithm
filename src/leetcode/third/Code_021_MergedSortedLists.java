package leetcode.third;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 合并2个有序链表
 *
 * @since 2019-12-15 Sunday
 */
public class Code_021_MergedSortedLists {
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4});
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4});
        ListNode h3 = LinkedListTool.generateList(new int[]{2, 2, 3, 4});
        LinkedListTool.printList(mergeTwoLists(h1, h2));
        LinkedListTool.printList(mergeTwoLists(h1, h3));
    }
}
