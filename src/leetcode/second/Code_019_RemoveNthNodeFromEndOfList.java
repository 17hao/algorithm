package leetcode.second;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 删除链表倒数第n个节点
 * 一趟遍历
 *
 * @since 2020-5-15 14:01 - 14:14
 */
public class Code_019_RemoveNthNodeFromEndOfList {
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = dummy;
        while (true) {
            ListNode tmp = cur;
            for (int i = 0; i <= n; i++) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode head3 = LinkedListTool.generateList(new int[]{1});
        LinkedListTool.printList(removeNthFromEnd(head1, 5));
        LinkedListTool.printList(removeNthFromEnd(head2, 3));
        LinkedListTool.printList(removeNthFromEnd(head3, 1));
    }
}
