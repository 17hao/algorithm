package leetcode.fifth;

import leetcode.tool.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @since 2020-3-26
 */
public class Code_098_ValidateBST {
    static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode node, Integer upper, Integer lower) {
        if (node == null) return true;
        if (upper == null && lower != null && node.val <= lower) return false;
        if (lower == null && upper != null && node.val >= upper) return false;
        if (upper != null && lower != null && (node.val <= lower || node.val >= upper)) return false;
        return helper(node.left, node.val, lower) & helper(node.right, upper, node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(11);
        System.out.println(isValidBST(root));
    }
}
