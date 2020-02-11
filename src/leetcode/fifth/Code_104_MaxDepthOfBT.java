package leetcode.fifth;

import tool.TreeNode;

/**
 * 二叉树最大深度
 *
 * @since 2020-2-11 Tuesday
 */
public class Code_104_MaxDepthOfBT {
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left =  new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        System.out.println(maxDepth(root));
    }
}
