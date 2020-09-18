package leetcode.fourth;

import leetcode.tool.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @since 2019-12-29 Sunday
 */
public class Code_104_MaxDepthOfBT {
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.right = new TreeNode(1);
        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(10);
        System.out.println(maxDepth(root));
    }
}
