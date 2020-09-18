package leetcode.second;

import leetcode.tool.TreeNode;

/**
 * 判断2棵树是否相同
 *
 * @since 2019-12-3 Thursday
 */
public class Code_100_SameTree {
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(4);

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(3);
        t3.left.left = new TreeNode(5);
        System.out.println(isSameTree(t1, t2));
        System.out.println(isSameTree(t1, t3));
    }
}
