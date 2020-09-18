package leetcode.third;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 回文链表
 *
 * @since 2020-4-11 Saturday 11:57 - 12:16
 */
public class Code_234_PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head, cur = slow, tail = null;
        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = tail;
            tail = cur;
        }
        ListNode l1 = cur;
        ListNode l2 = fast == null ? slow : slow.next;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 2, 3, 2, 1});
        System.out.println(isPalindrome(head));
    }
}
