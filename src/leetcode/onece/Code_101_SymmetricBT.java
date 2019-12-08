package leetcode.onece;

import tool.TreeNode;

/**
 * 检查二叉树是否对称
 *
 * @since 2019-12-8 Sunday
 */
public class Code_101_SymmetricBT {
    boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        System.out.println(new Code_101_SymmetricBT().isSymmetric(root));
    }
}
