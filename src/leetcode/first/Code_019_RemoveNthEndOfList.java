package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-22 11:10
 */
public class Code_019_RemoveNthEndOfList {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = head;
        int sum = 0;
        while (cur != null) {
            cur = cur.next;
            sum += 1;
        }
        int position = sum - n + 1;
        int temp = 0;
        cur = dummyHead;
        while (cur != null) {
            if (temp == position - 1) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            temp += 1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = 2;
        ListNode l = LinkedListTool.generateList(arr);
        ListNode res = removeNthFromEnd(l, n);
        LinkedListTool.printList(res);
    }
}
