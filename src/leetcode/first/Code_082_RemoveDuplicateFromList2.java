package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-26 14:29
 */
public class Code_082_RemoveDuplicateFromList2 {
    private static ListNode removeDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode temp;
        while (true) {
            if (cur != null) {
                if (cur.next == null || cur.next.next == null) break;
                if (cur.next.val == cur.next.next.val) {
                    temp = cur.next;
                    while (temp.val == cur.next.val) {
                        temp = temp.next;
                        if (temp == null) break;
                    }
                    cur.next = temp;
                } else {
                    cur = cur.next;
                }
            } else {
                break;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = LinkedListTool.generateList(arr);
        ListNode res = removeDuplicates(head);
        LinkedListTool.printList(res);
    }
}
