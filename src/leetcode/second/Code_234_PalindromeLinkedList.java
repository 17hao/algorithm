package leetcode.second;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 回文链表
 *
 * @since 2019-12-16 Monday
 */
public class Code_234_PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, cur = null, tail = null;
        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = tail;
            tail = cur;
        }
        ListNode p1 = cur;
        ListNode p2 = (fast == null) ? slow : slow.next;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2});
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 2, 1});
        ListNode h3 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 3, 2, 1});
        ListNode h4 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 3, 2});
        System.out.println(isPalindrome(h1));
        System.out.println(isPalindrome(h2));
        System.out.println(isPalindrome(h3));
        System.out.println(isPalindrome(h4));
    }
}
