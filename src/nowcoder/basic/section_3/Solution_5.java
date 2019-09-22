package nowcoder.basic.section_3;

import tool.LinkedListTool;
import tool.ListNode;

public class Solution_5 {
    ListNode insertionSortList(ListNode head) {
        if (head.next == null) return head;
        else {
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            while (head != null) {
                ListNode next = head.next;
                ListNode cur = dummy;
                while (cur.next != null && head.val > cur.next.val) {
                    cur = cur.next;
                }
                head.next = cur.next;
                cur.next = head;
                head = next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution_5 s = new Solution_5();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int[] c = {2, 1, 5, 2, 6};
        int[] d = {1};
        int[] e = {1, 2};
        int[] f = {3, 2, 1};
        ListNode head = LinkedListTool.generateList(c);
        LinkedListTool.printList(head);
        System.out.println();
        LinkedListTool.printList(s.insertionSortList(head));
    }
}
