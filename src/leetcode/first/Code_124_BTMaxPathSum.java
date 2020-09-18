package leetcode.first;

import leetcode.tool.TreeNode;

/**
 * 二叉树最大路径和
 */
public class Code_124_BTMaxPathSum {
    private int res = Integer.MIN_VALUE;

    int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max((left + right + root.val), res);
        return Math.max(Math.max(left, right) + root.val, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Code_124_BTMaxPathSum().maxPathSum(root));
    }
}
