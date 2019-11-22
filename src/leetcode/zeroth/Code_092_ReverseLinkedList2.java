package leetcode.zeroth;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-26 13:01
 */
public class Code_092_ReverseLinkedList2 {
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode tempHeadPre = dummyHead;
        ListNode tempHead = dummyHead;
        ListNode tempTail = dummyHead;
        int index = 0;
        while (cur != null) {
            if (index == m - 1) {
                tempHeadPre = cur;
                tempHead = cur.next;
            } else if (index == n) {
                tempTail = cur;
                break;
            }
            cur = cur.next;
            index += 1;
        }
        while (tempHead != tempTail) {
            ListNode temp = tempHead.next;
            ListNode tempTailNext = tempTail.next;
            tempTail.next = tempHead;
            tempHead.next = tempTailNext;
            tempHead = temp;
        }
        tempHeadPre.next = tempTail;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int m = 2;
        int n = 4;
        ListNode l = LinkedListTool.generateList(arr);
        ListNode res = reverseBetween(l, m, n);
        LinkedListTool.printList(res);
    }
}
