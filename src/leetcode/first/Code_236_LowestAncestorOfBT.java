package leetcode.first;

import leetcode.tool.TreeNode;

/**
 * 二叉树最近公共祖先
 *
 * @since 2020-4-18 Saturday 12:42
 */
public class Code_236_LowestAncestorOfBT {
    private static TreeNode res = null;

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            helper(root, p, q);
            return res;
        }
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
        TreeNode p = new TreeNode(10086);
        TreeNode q = new TreeNode(10000);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = p;
        root.right.right = q;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
