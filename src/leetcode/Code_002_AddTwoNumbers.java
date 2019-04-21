package leetcode;

import tool.LinkedListTool;
import tool.ListNode;

import java.util.LinkedList;

/**
 * @author 17hao
 * @date 2019-04-12 16:50
 */
public class Code_002_AddTwoNumbers {
    //todo big integer unsolved
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // int num1 = listToNum(l1);
        // int num2 = listToNum(l2);
        // int res = num1 + num2;
        // // if (res > Integer.MAX_VALUE){
        // //
        // // }
        // ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        // ListNode cur = dummyHead;
        // if (res == 0) {
        //     dummyHead.next = new ListNode(0);
        // } else {
        //     while (res > 0) {
        //         cur.next = new ListNode(res % 10);
        //         cur = cur.next;
        //         res /= 10;
        //     }
        // }
        // return dummyHead.next;
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyNode;
        while (l1 != null || l2 != null) {
            int tmp = l1.val + l2.val;
            cur.next = new ListNode(tmp >= 10 ? tmp - 10 : tmp);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummyNode.next;
    }

    private static int listToNum(ListNode l1) {
        LinkedList<Integer> list1 = new LinkedList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        int num = 0;
        for (int i = list1.size() - 1; i >= 0; i--) {
            num += list1.get(i) * Math.pow(10, i);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr1 = {9};
        int[] arr2 = {1};
        //int[] arr2 = {1, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = LinkedListTool.generateList(arr1);
        ListNode l2 = LinkedListTool.generateList(arr2);
        ListNode res = addTwoNumbers(l1, l2);
        LinkedListTool.printList(res);
    }
}
