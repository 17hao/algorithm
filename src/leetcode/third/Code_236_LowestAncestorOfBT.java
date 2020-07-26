package leetcode.third;

import tool.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 
 * @since 2020-7-26 Sunday 21:08 - 21:21
 */
public class Code_236_LowestAncestorOfBT {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        
    }
}