package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-26 14:12
 */
public class Code_083_RemoveDuplicateFromList {
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode temp;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                temp = cur.next.next;
                cur.next = temp;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 5};
        ListNode l = LinkedListTool.generateList(arr);
        ListNode res = deleteDuplicates(l);
        LinkedListTool.printList(res);
    }
}
