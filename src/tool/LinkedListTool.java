package tool;

/**
 * @author 17hao
 * @since 2019/4/7
 */
public class LinkedListTool {
    public static ListNode generateList(int[] arr) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        for (int value : arr) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return dummyHead.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }
}
