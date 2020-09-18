package leetcode.first;

import leetcode.tool.TreeNode;

/**
 * 平衡二叉树
 *
 * @since 2020-4-18 Saturday 12:05
 */
public class Code_110_BalancedBinaryTree {
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        System.out.println(isBalanced(root));
    }
}
