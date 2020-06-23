package leetcode.first;

import tool.LinkedListTool;
import tool.ListNode;
import tool.TreeNode;

/**
 * 将有序链表转换成高度平衡的二叉搜索树
 *
 * @since 2020-6-23 Tuesday 15:10
 */
public class Code_109_ConvertSortedListToBST {
    static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode fast = pre.next, slow = pre.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTool.generateList(new int[]{-10, -3, 0, 5, 9});
        ListNode head2 = LinkedListTool.generateList(new int[]{-10, -3, 0, 5});
        TreeNode root = sortedListToBST(head);
        Code_102_LevelOrderBT c = new Code_102_LevelOrderBT();
        System.out.println(c.levelOrder(root));
    }
}
