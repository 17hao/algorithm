package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * @since 2019-12-25 Wednesday 13:17 - 13:46
 */
public class Code_002_AddTwoNumbers {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            int n1 = l1.val;
            int n2 = l2.val;
            int sum = n1 + n2 + carry;
            ListNode temp = new ListNode(sum % 10);
            cur.next = temp;
            cur = temp;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            while (carry > 0 && l2 != null) {
                int sum = l2.val + carry;
                l2.val = sum % 10;
                carry = sum / 10;
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
            cur.next = l2;
        }
        if (l2 == null && l1 != null) {
            while (carry > 0 && l1 != null) {
                int sum = l1.val + carry;
                l1.val = sum % 10;
                carry = sum / 10;
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
            cur.next = l1;
        }
        if (l1 == null && l2 == null && carry > 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.generateList(new int[]{2, 4, 3});
        ListNode l2 = LinkedListTool.generateList(new int[]{5, 6, 4});
        ListNode l3 = LinkedListTool.generateList(new int[]{5, 4, 3, 2, 1});
        ListNode l4 = LinkedListTool.generateList(new int[]{5, 5});
        ListNode l5 = LinkedListTool.generateList(new int[]{9, 9});
        ListNode l6 = LinkedListTool.generateList(new int[]{1});
        ListNode l7 = LinkedListTool.generateList(new int[]{9, 9, 9, 9});
        LinkedListTool.printList(addTwoNumbers(l1, l2)); // 342+465=807 => 7->0->8
        LinkedListTool.printList(addTwoNumbers(l1, l3)); // 342+12345=12687
        LinkedListTool.printList(addTwoNumbers(l2, l3)); // 465+12345=12810
        LinkedListTool.printList(addTwoNumbers(l4, l4));
        LinkedListTool.printList(addTwoNumbers(l5, l6));
        LinkedListTool.printList(addTwoNumbers(l6, l7));
    }
}
