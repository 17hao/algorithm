package leetcode.second;

import tool.TreeNode;

/**
 * 二叉树的最大路径和
 *
 * @since 2020-4-29 Wednesday 23:21
 */
public class Code_124_MaxPathSumOfBT {
    private int res = Integer.MIN_VALUE;

    int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
