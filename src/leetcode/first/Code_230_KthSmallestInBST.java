package leetcode.first;

import tool.TreeNode;

/**
 * 查找二叉树中第 k 个最小的元素。
 *
 * @since 2019-12-22 Sunday
 */
public class Code_230_KthSmallestInBST {
    private int result;
    private int count = 0;

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
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Code_230_KthSmallestInBST().kthSmallest(root, 1));
        System.out.println(new Code_230_KthSmallestInBST().kthSmallest(root, 2));
    }
}
