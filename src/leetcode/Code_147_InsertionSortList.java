package leetcode;

import tool.CommonTool;
import tool.LinkedListTool;
import tool.ListNode;

/**
 * 对链表进行插入排序
 *
 * @author sqh
 * @date 2018-12-18
 * finished on 2019-4-7
 */
public class Code_147_InsertionSortList {
    private static ListNode insertLinkedList(ListNode head) {
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
        int[] arr = CommonTool.generateArray(10, 3);
        ListNode head = LinkedListTool.generateList(arr); //返回了哨兵节点
        ListNode currentHead = insertLinkedList(head);  //经操作后真正的头结点
        LinkedListTool.printList(currentHead);
    }
}
