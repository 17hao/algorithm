package leetcode;

/**
 * 对链表进行插入排序
 *
 * @author sqh
 * @since 2018/12/18
 * @finish 2019/4/7
 */
public class Code_147_InsertionSortList {
    static ListNode insertLinkedList(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE); //链表的哨兵节点
        dummyHead.next = head;
        ListNode cur = head; //负责查找需要插入的节点
        while (cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
            }
            ListNode tmp = cur.next, q = dummyHead;
            cur.next = cur.next.next;
            while (q.next.val < tmp.val) {
                q = q.next;
            }
            tmp.next = q.next;
            q.next = tmp;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(0);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        insertLinkedList(head);
        System.out.println(head.val + " -> " + head.next.val + " -> " + head.next.next.val + " -> " + head.next.next.next.val + " -> " + head.next.next.next.next.val);
    }
}
