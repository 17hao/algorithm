package leetcode.zeroth;

import tool.TreeNode;

/**
 * 计算二叉树最大深度.
 * 树深度二叉树的深度为根节点到最远叶子节点的最长路径上的节点数.
 *
 * @since 2019-12-3 Thursday
 */
public class Code_104_MaxDepthOfBinaryTree {
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth =  maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(++leftDepth, ++rightDepth);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.left = new TreeNode(8);
        System.out.println(maxDepth(head));
    }
}
