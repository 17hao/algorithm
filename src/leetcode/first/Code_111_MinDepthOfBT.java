package leetcode.first;

import tool.TreeNode;

/**
 * 二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 叶子节点是指没有子节点的节点。
 *
 * @since 2019-12-7 Saturday
 */
public class Code_111_MinDepthOfBT {
    static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
//        if (root.right == null) return leftDepth + 1;
//        if (root.left == null) return rightDepth + 1;
        if (root.left == null || root.right == null) return leftDepth + rightDepth + 1;
        else return Math.min(++leftDepth, ++rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(5);
        System.out.println(minDepth(root));
    }
}
