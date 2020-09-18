package leetcode.third;

import leetcode.tool.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @since 2019-12-15 Sunday
 */
public class Code_104_MaxDepthOfBT {
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}
