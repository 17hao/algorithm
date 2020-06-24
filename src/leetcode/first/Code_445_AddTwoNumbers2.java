package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

import java.util.Stack;

/**
 * 两数相加2, 链表头存储的是高位
 *
 * @since 2020-6-24 Wednesday 12:02
 */
public class Code_445_AddTwoNumbers2 {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!s1.empty() && !s2.empty()) {
            int tmp = s1.pop() + s2.pop() + carry;
            ListNode l = dummy.next;
            dummy.next = new ListNode(tmp % 10);
            dummy.next.next = l;
            carry = tmp / 10;
        }
        if (s1.empty()) {
            while (!s2.empty()) {
                int tmp = s2.pop() + carry;
                ListNode l = dummy.next;
                dummy.next = new ListNode(tmp % 10);
                dummy.next.next = l;
                carry = tmp / 10;
            }
        } else {
            while (!s1.empty()) {
                int tmp = s1.pop() + carry;
                ListNode l = dummy.next;
                dummy.next = new ListNode(tmp % 10);
                dummy.next.next = l;
                carry = tmp / 10;
            }
        }
        if (carry == 1) {
            ListNode l = dummy.next;
            dummy.next = new ListNode(1);
            dummy.next.next = l;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{9, 9, 9});
        ListNode h2 = LinkedListTool.generateList(new int[]{1});
        ListNode h3 = LinkedListTool.generateList(new int[]{3, 2, 2});
        LinkedListTool.printList(addTwoNumbers(h1, h2));
        LinkedListTool.printList(addTwoNumbers(h1, h3));
    }
}
