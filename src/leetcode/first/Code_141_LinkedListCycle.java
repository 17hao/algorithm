package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;

/**
 * @author 17hao
 * @date 2019-04-22 10:31
 */
public class Code_141_LinkedListCycle {
    private static boolean hasCycle(ListNode head) {
        boolean res = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.next == null || fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                res = true;
                break;
            }
        }
        return res;
    }
        public static void main (String[]args){
            int[] arr = {1,2,3,4,5};
            ListNode l = LinkedListTool.generateList(arr);
            boolean res = hasCycle(l);
            System.out.println(res);
        }
    }
