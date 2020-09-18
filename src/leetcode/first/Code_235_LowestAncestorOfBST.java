package leetcode.first;

import leetcode.tool.TreeNode;

/**
 * 二叉搜索树的最近公共节点
 *
 * @since 2020-4-26 19:01
 */
public class Code_235_LowestAncestorOfBST {
    TreeNode res = null;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            res = root;
        } else if (root.val > p.val && root.val > q.val) {
            helper(root.left, p, q);
        } else {
            helper(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(6);
        root.left.left = p;
        root.left.right = q;
        Code_235_LowestAncestorOfBST c = new Code_235_LowestAncestorOfBST();
        System.out.println(c.lowestCommonAncestor(root, p, q));
    }
}
