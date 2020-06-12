package leetcode.third;

import tool.TreeNode;

/**
 * 二叉树的最大路径
 * 对于每个节点: 计算该节点为根节点的子树能为最大路径贡献的路径长度(这条路径要么来自左子树,要么来自右子树,要么为0); 该节点为根节点的子树的最大路径
 *
 * @since 2020-6-12 Friday 17:50
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
        Code_124_BTMaxPathSum c = new Code_124_BTMaxPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(c.maxPathSum(root));
    }
}
