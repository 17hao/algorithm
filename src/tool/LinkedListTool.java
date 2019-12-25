package tool;

/**
 * @author 17hao
 * @since 2019-04-07
 */
public class LinkedListTool {
    /**
     * generate a linked list by given array
     *
     * @return the head of linked list
     */
    public static ListNode generateList(int[] array) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        for (int value : array) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    /**
     * print linked list
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null\n");
    }
}
