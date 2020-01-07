package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * 两两交换链表节点
 *
 * @since 2020-1-7
 */
public class Code_024_SwapNodesInPairs {
    static ListNode swapPairsV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsV1(next.next);
        next.next = head;
        return next;
    }

    static ListNode swapPairsV2(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode front = pre.next, end = front.next, tail = end.next;
            pre.next = end;
            end.next = front;
            front.next = tail;
            pre = front;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode h2 = LinkedListTool.generateList(new int[]{1, 2, 3, 4, 5, 6, 7});
        LinkedListTool.printList(swapPairsV1(h1));
        LinkedListTool.printList(swapPairsV1(h2));
        System.out.println("===");
        LinkedListTool.printList(swapPairsV2(h1));
        LinkedListTool.printList(swapPairsV2(h2));
    }
}
