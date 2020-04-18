package leetcode.first;

import tool.TreeNode;

/**
 * 路径总和
 *
 * @since 2020-4-18 Saturday 12:17
 */
public class Code_112_PathSum {
    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            sum -= root.val;
            if (root.left == null && root.right == null) {
                return sum == 0;
            }
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(1);
        System.out.println(hasPathSum(root, 0));
        System.out.println(hasPathSum(root, 1));
        System.out.println(hasPathSum(root, 5));
    }
}
