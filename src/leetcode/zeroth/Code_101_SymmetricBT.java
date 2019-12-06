package leetcode.zeroth;

import tool.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @since 2019-12-6 Friday
 */
public class Code_101_SymmetricBT {
    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return process(root.left, root.right);
    }

    static boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
                && process(left.left, right.right)
                && process(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
