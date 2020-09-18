package leetcode.first;

import leetcode.tool.LinkedListTool;
import leetcode.tool.ListNode;

/**
 * @author 17hao
 * @date 2019-05-01 15:58
 */
public class Code_237_DeleteNode {
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListTool.generateList(arr);
        deleteNode(head.next);
        LinkedListTool.printList(head);
    }
}
