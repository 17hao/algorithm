package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @since 2019-12-27 Friday
 */
public class Code_160_IntersectionOfLinkedList {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.generateList(new int[]{1, 2, 3});
        ListNode l2 = LinkedListTool.generateList(new int[]{1, 2, 3});
        System.out.println(getIntersectionNode(l1, l2));
    }
}
