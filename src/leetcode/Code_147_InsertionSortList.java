package leetcode;

/**
 * 对链表进行插入排序
 *
 * @author sqh
 * @finish 2019/4/7
 * @since 2018/12/18
 */
public class Code_147_InsertionSortList {
    static ListNode insertLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE); //链表的哨兵节点
        dummyHead.next = head;
        ListNode cur = head; //负责找到需要插入的节点
        while (cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;  //cur.next就是需要插入的元素
            } else {
                ListNode tmp = cur.next;
                ListNode d = dummyHead;
                cur.next = cur.next.next;
                while (d.next.val < tmp.val) {
                    d = d.next;
                }
                tmp.next = d.next;
                d.next = tmp;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        //int[] arr = {4, 3, 2, 5, 6, 7, 1, 0};
        //int[] arr = {-1, 5, 3, 4, 0};
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        for (int value : arr) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        ListNode realHead = insertLinkedList(dummyHead.next);
        while (realHead != null) {
            System.out.print(realHead.val + "->");
            realHead = realHead.next;
        }
    }
}
