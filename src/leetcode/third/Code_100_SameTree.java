package leetcode.third;

import tool.TreeNode;

/**
 * 判断2棵二叉树是否相同
 *
 * @since 2019-12-4 Wednesday
 */
public class Code_100_SameTree {
    static boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);

        TreeNode m = new TreeNode(1);
        m.left = new TreeNode(3);

        System.out.println(sameTree(p, q));
        System.out.println(sameTree(p, m));
    }
}
