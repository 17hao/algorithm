package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @since 2019-12-14 Saturday
 */
public class Code_021_MergeSortedLinkedList {
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
        ListNode l1 = LinkedListTool.generateList(new int[]{1, 2, 3});
        ListNode l2 = LinkedListTool.generateList(new int[]{2, 3, 4});
        ListNode l3 = LinkedListTool.generateList(new int[]{5, 6, 7});
        //LinkedListTool.printList(mergeTwoLists(l1, l2));
        System.out.println("");
        //LinkedListTool.printList(mergeTwoLists(l1, l3));
        // System.out.println("");
         LinkedListTool.printList(mergeTwoLists(l2, l3));
    }
}
