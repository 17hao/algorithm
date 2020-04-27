package leetcode.second;

import tool.TreeNode;

/**
 * 二叉树最近公共节点
 *
 * @since 2020-4-24 Friday 09:08
 */
public class Code_236_LowestCommonAncestorOfBT {
    static TreeNode res;
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        helper(root, p, q);
        return res;
    }

    private static boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        boolean mid = root == p || root == q;
        if (mid ? (left || right) : (left && right)) {
            res = root;
        }
        return mid || left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(5);
        root.right.left = p;
        root.right.right = q;
        System.out.println(lowestCommonAncestor(root, p, q));
    }
}
