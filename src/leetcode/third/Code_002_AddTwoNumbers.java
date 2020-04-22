package leetcode.third;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 两数相加
 * i.e. (2 -> 4 -> 3) + (5 -> 6 -> 4) = 342 + 465 = 807
 *
 * @since 2020-4-22 Wednesday 10:43 - 11: 08
 */
public class Code_002_AddTwoNumbers {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        int additional = 0;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode((l1.val + l2.val + additional) % 10);
            cur.next = tmp;
            cur = tmp;
            additional = (l1.val + l2.val +  +additional) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                cur.next = new ListNode((l2.val + additional) % 10);
                additional = (l2.val + additional) / 10;
                cur = cur.next;
                l2 = l2.next;
            }
            cur.next = additional == 1 ? new ListNode(1) : null;
        } else if (l1 != null && l2 == null) {
            while (l1 != null) {
                cur.next = new ListNode((l1.val + additional) % 10);
                additional = (l1.val + additional) / 10;
                cur = cur.next;
                l1 = l1.next;
            }
            cur.next = additional == 1 ? new ListNode(1) : null;
        } else {
            if (additional > 0) {
                cur.next = new ListNode(1);
                cur = cur.next;
            }
            cur.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l2 = LinkedListTool.generateList(new int[]{2, 4, 3});
        ListNode l1 = LinkedListTool.generateList(new int[]{5, 6, 7});
        ListNode l3 = LinkedListTool.generateList(new int[]{1});
        ListNode l4 = LinkedListTool.generateList(new int[]{9, 9, 9});
        ListNode l5 = LinkedListTool.generateList(new int[]{3, 7});
        ListNode l6 = LinkedListTool.generateList(new int[]{9, 2});
        LinkedListTool.printList(addTwoNumbers(l1, l2));
        LinkedListTool.printList(addTwoNumbers(l3, l4));
        LinkedListTool.printList(addTwoNumbers(l5, l6));
    }
}
