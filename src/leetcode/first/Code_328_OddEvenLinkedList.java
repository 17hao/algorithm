package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 奇偶链表
 *
 * @since 2020-1-4 22:30
 */
public class Code_328_OddEvenLinkedList {
    static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListTool.generateList(new int[]{1,2,3,4,5,6,7});
        ListNode head2 = LinkedListTool.generateList(new int[]{1,2,3,4,5,6});
        ListNode res1 = oddEvenList(head1);
        ListNode res2 = oddEvenList(head2);
        LinkedListTool.printList(res1);
        LinkedListTool.printList(res2);
    }
}
