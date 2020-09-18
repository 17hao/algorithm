package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-12 16:50
 * finished at 2019-4-29 15:10
 */
public class Code_002_AddTwoNumbers {
    //todo practice again!
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        boolean f = false;
        while (l1 != null && l2 != null) {
            int temp = !f ? l1.val + l2.val : l1.val + l2.val + 1;
            f = temp >= 10;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode continuous = l1 == null ? l2 : l1; //选出需要继续遍历的链表
        while (continuous != null) {
            int temp = f ? 1 + continuous.val : continuous.val;
            f = temp >= 10;
            temp = temp >= 10 ? temp % 10 : temp;
            cur.next = new ListNode(temp);
            cur = cur.next;
            continuous = continuous.next;
        }
        if (f) cur.next = new ListNode(1);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {3};
        int[] arr2 = {9, 2};
        ListNode l1 = LinkedListTool.generateList(arr1);
        ListNode l2 = LinkedListTool.generateList(arr2);
        ListNode res = addTwoNumbers(l1, l2);
        LinkedListTool.printList(res);
    }
}
