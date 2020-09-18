package leetcode.second;

import leetcode.tool.TreeNode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * @since 2019-12-24 Tuesday
 */
public class Code_230_KthSmallestInBST {
    private int count = 0;
    private int result = 0;

    int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        } else {
            helper(root.left, k);
            if (++count == k) {
                result = root.val;
            }
            helper(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Code_230_KthSmallestInBST().kthSmallest(root, 2));
        System.out.println(new Code_230_KthSmallestInBST().kthSmallest(root, 3));
    }
}
