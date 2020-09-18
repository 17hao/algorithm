package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * 分隔链表
 *
 * @since 2020-6-14 Sunday 15:08 - 15:21
 */
public class Code_086_PartitionLIst {
    static ListNode partition(ListNode head, int x) {
        ListNode bigger = new ListNode(0), litter = new ListNode(0);
        ListNode tmpB = bigger, tmpL = litter;
        while (head != null) {
            if (head.val < x) {
                tmpL.next = new ListNode(head.val);
                tmpL = tmpL.next;
            } else {
                tmpB.next = new ListNode(head.val);
                tmpB = tmpB.next;
            }
            head = head.next;
        }
        tmpL.next = bigger.next;
        return litter.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{1, 4, 3, 2, 5, 2});
        LinkedListTool.printList(partition(head, 3));
//        LinkedListTool.printList(partition(head, 4));
    }
}
