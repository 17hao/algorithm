package leetcode.first;

import tool.CommonTool;
import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-4-7
 */
public class Code_206_ReverseList {
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            ListNode tmpNext = dummyHead.next;
            cur.next = tmp.next;
            dummyHead.next = tmp;
            tmp.next = tmpNext;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = CommonTool.generateArray(10, 3);
        ListNode head = LinkedListTool.generateList(arr);
        ListNode currentHead = reverseList(head);
        LinkedListTool.printList(currentHead);
    }
}
