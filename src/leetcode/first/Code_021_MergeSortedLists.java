package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-21 12:01
 */
public class Code_021_MergeSortedLists {
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 4, 5, 6, 7, 8, 9, 11};
        ListNode l1 = LinkedListTool.generateList(arr1);
        ListNode l2 = LinkedListTool.generateList(arr2);
        ListNode res = mergeTwoLists(l1, l2);
        LinkedListTool.printList(res);
    }
}
