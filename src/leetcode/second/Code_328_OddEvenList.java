package leetcode.second;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 奇偶链表
 *
 * @since 2020-1-6 17:20
 */
public class Code_328_OddEvenList {
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
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
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6, 7});
        LinkedListTool.printList(oddEvenList(h1));
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6});
        LinkedListTool.printList(oddEvenList(h2));
    }
}
