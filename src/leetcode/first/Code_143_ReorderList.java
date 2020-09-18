package leetcode.first;

import java.util.LinkedList;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 重排链表
 * 
 * @since 2020-7-9 Thursday 19:45
 */
public class Code_143_ReorderList {
    void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.addLast(head);
            head = head.next;
        }
        while (!list.isEmpty()) {
            if (head == null) {
                head = list.pollFirst();
            } else {
                head.next = list.pollFirst();
                head = head.next;
            }
            head.next = list.pollLast();
            head = head.next;
        }
        if (head != null) {
            head.next = null;
        }
    }

    public static void main(String[] args) {
        Code_143_ReorderList c = new Code_143_ReorderList();

        ListNode head1 = LinkedListTool.generateList(new int[] { 1, 2, 3, 4 });
        c.reorderList(head1);
        LinkedListTool.printList(head1);

        ListNode head2 = LinkedListTool.generateList(new int[] { 1, 2, 3, 4, 5 });
        c.reorderList(head2);
        LinkedListTool.printList(head2);
    }
}