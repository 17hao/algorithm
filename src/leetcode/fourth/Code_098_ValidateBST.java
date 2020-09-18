package leetcode.fourth;

import leetcode.tool.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @since 2019-12-29 Sunday
 */
public class Code_098_ValidateBST {
    boolean isValidBST(TreeNode root) {
        return helper(root.left, null, root.val)
                && helper(root.right, root.val, null);
    }

    private boolean helperV2(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;
        if (higher != null && root.val >= higher) return false;
        if (lower != null && root.val <= lower) return false;
        return helperV2(root.left, lower, root.val) && helperV2(root.right, root.val, higher);
    }

    private boolean helper(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;
        if (lower == null && higher != null && root.val >= higher) {
            return false;
        }
        if (lower != null && higher == null && root.val <= lower) {
            return false;
        }
        if (lower != null && higher != null && (root.val >= higher || root.val <= lower)) {
            return false;
        }
        return helper(root.left, lower, root.val) && helper(root.right, root.val, higher);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        System.out.println(new Code_098_ValidateBST().isValidBST(root));
    }
}
