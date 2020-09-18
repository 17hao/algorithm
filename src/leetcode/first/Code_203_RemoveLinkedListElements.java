package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-21 09:52
 */
public class Code_203_RemoveLinkedListElements {
    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode next = cur.next;
        while (next != null) {
            if (next.val != val) {
                cur = cur.next;
                next = cur.next;
            } else {
                next = next.next;
                cur.next = next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        ListNode head = LinkedListTool.generateList(arr);
        ListNode res = removeElements(head, 1);
        LinkedListTool.printList(res);
    }
}
