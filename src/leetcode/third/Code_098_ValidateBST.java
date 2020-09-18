package leetcode.third;

import leetcode.tool.TreeNode;

/**
 * 验证是否是平衡二叉树
 *
 * @since 2019-12-13 Friday
 */
public class Code_098_ValidateBST {
    boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;
        if (lower != null && lower >= root.val) return false;
        if (higher != null && higher <= root.val) return false;
        return helper(root.left, lower, root.val) && helper(root.right, root.val, higher);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new Code_098_ValidateBST().isValidBST(root));
    }
}
