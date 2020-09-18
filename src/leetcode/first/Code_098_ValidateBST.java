package leetcode.first;


import leetcode.tool.TreeNode;

import java.util.Stack;

/**
 * 验证是否是BST
 *
 * @since 2019-12-5 Thursday
 */
public class Code_098_ValidateBST {


    static boolean isValidBST(TreeNode root) {
        return process(root, null, null);
    }

    static boolean process(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!process(root.left, lower, val)) return false;
        if (!process(root.right, val, upper)) return false;
        return true;
    }

    static boolean isValidBSTV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inOrder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        // root.right.left = new TreeNode(9);
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTV2(root));
    }
}
