package leetcode.second;

import tool.TreeNode;

/**
 * 计算二叉树的最大深度.
 *
 * @since 2019-12-4 Wednesday
 */
public class Code_104_MacDepthOfBT {
    static int maxDepthOfBT(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepthOfBT(root.left);
            int rightDepth = maxDepthOfBT(root.right);
            return Math.max(++leftDepth, ++rightDepth);
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        System.out.println(maxDepthOfBT(p));
    }
}
