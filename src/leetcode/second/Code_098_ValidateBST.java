package leetcode.second;

import tool.TreeNode;

/**
 * 验证一棵树是否是BST
 *
 * @since 2019-12-6 Friday
 */
public class Code_098_ValidateBST {
    static boolean isValidBST(TreeNode root) {
        return process(root, null, null);
    }

    static boolean process(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        int val = root.val;
        if (!process(root.left, lower, val)) return false;
        return process(root.right, val, upper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.right.left = new TreeNode(7);
        System.out.println(isValidBST(root));
    }
}
