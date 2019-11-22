package leetcode.zeroth;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-29 12:52
 */
public class Code_160_IntersectionOfLinkedList {
    //todo practice again!
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {4, 5, 6, 7};
        ListNode l1 = LinkedListTool.generateList(arr1);
        ListNode l2 = LinkedListTool.generateList(arr2);
        ListNode res = getIntersectionNode(l1, l2);
        System.out.println(res == null ? "null" : res.val);
    }
}
