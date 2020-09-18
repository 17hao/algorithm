package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @since 2019-10-1
 * @update 2020-3-20
 */
public class Code_094_InOrderTraversal {

    /**
     * recursive
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        return process(root, result);
    }

    private static List<Integer> process(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            process(root.left, result);
            result.add(root.val);
            process(root.right, result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        List<Integer> result = inorderTraversal(head);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
